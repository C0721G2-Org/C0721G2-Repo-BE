package com.c0721g2srsrealestatebe.controller;

import com.c0721g2srsrealestatebe.jwt.JwtUtils;
import com.c0721g2srsrealestatebe.model.account.AppUser;
import com.c0721g2srsrealestatebe.model.customer.Customer;
import com.c0721g2srsrealestatebe.payload.request.*;
import com.c0721g2srsrealestatebe.payload.response.JwtResponse;
import com.c0721g2srsrealestatebe.payload.response.MessageResponse;
import com.c0721g2srsrealestatebe.service.account.impl.AppUserServiceImpl;
import com.c0721g2srsrealestatebe.service.account.impl.MyUserDetailsImpl;
import com.c0721g2srsrealestatebe.service.account.impl.UserDetailsServiceImpl;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import com.google.api.client.json.jackson2.JacksonFactory;


import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/public")
@CrossOrigin(origins = "*")
public class SecurityController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AppUserServiceImpl appUserService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Value("${google.clientId}")
    String googleClientId;

    @Value("${secretPsw}")
    String secretPsw;


    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                        loginRequest.getPassword()));
        System.out.println("test1");

        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println("test2");

        MyUserDetailsImpl myUserDetails = (MyUserDetailsImpl) authentication.getPrincipal();
        String jwtToken = jwtUtils.generateToken(myUserDetails);

        List<String> roles = myUserDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        System.out.println("jwttoken: " + jwtToken);
        System.out.println("jwttoken: " + myUserDetails.getUsername());
        System.out.println("jwttoken: " + roles);
        return ResponseEntity.ok(new JwtResponse(jwtToken, myUserDetails.getUsername(), roles));

    }

    @PostMapping("/send-verification-email")
    public ResponseEntity<?> reset(@RequestBody LoginRequest loginRequest) throws MessagingException, UnsupportedEncodingException {
        if (appUserService.existsUserByEmail(loginRequest.getEmail())) {
            appUserService.addVerificationCode(loginRequest.getEmail());
            return ResponseEntity.ok(new MessageResponse("Đã gửi email xác nhận"));
        }
        return ResponseEntity
                .badRequest()
                .body(new MessageResponse("Tài khoản không tồn tại"));
    }

    @PostMapping("/check-verification-code")
    public ResponseEntity<?> checkVerificationCode(@RequestBody VerifyRequest verifyRequest) {
        Boolean isVerified = appUserService.findUserByVerificationCode(verifyRequest.getCode());
        System.out.println("Code:" + verifyRequest.getCode());
        if (isVerified) {
            return ResponseEntity.ok(new MessageResponse("valid"));
        } else {
            return ResponseEntity.ok(new MessageResponse("invalid"));
        }
    }

    @PostMapping("/reset-password")
    public ResponseEntity<?> doResetPassword(@Valid @RequestBody ResetPasswordRequest resetPassRequest) {
        if (resetPassRequest.getNewPassword().equals(resetPassRequest.getReNewPassword())) {
            appUserService.saveNewPassword(bCryptPasswordEncoder.encode(resetPassRequest.getNewPassword()), resetPassRequest.getVerificationCode());
            return ResponseEntity.ok(new MessageResponse("success"));
        }
        return ResponseEntity
                .badRequest()
                .body(new MessageResponse("error"));

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @PostMapping("/google")
    public ResponseEntity<?> google(@RequestBody TokenSocialRequest token) throws IOException {
        final NetHttpTransport transport = new NetHttpTransport();
        final JacksonFactory jacksonFactory = JacksonFactory.getDefaultInstance();
        GoogleIdTokenVerifier.Builder verifier =
                new GoogleIdTokenVerifier.Builder(transport, jacksonFactory)
                        .setAudience(Collections.singletonList(googleClientId));
        final GoogleIdToken googleIdToken = GoogleIdToken.parse(verifier.getJsonFactory(), token.getToken());
        final GoogleIdToken.Payload payload = googleIdToken.getPayload();

        AppUser appUser = new AppUser();
        if (appUserService.existsUserByEmail(payload.getEmail())) {
            appUser = appUserService.getAppUserByEmail(payload.getEmail());
        } else {
            CustomerSocial customerSocial = new CustomerSocial();
            customerSocial.setEmail(payload.getEmail());
            customerSocial.setName(payload.get("name").toString());
            customerSocial.setPassword(bCryptPasswordEncoder.encode(secretPsw));

            appUser = appUserService.createCustomerSocial(customerSocial);

        }

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(appUser.getUsername());
        loginRequest.setPassword(secretPsw);
        return authenticateUser(loginRequest);
    }

    @PostMapping("/facebook")
    public ResponseEntity<?> facebook(@RequestBody TokenSocialRequest tokenSocialRequest) throws IOException {
        Facebook facebook = new FacebookTemplate(tokenSocialRequest.getToken());
        final String[] fields = {"email", "name"};
        User user = facebook.fetchObject("me", User.class, fields);
        AppUser appUser = new AppUser();
        if (appUserService.existsUserByEmail(user.getEmail())) {
            appUser = appUserService.getAppUserByEmail(user.getEmail());

        } else {
            CustomerSocial customerSocial = new CustomerSocial();
            customerSocial.setEmail(user.getEmail());
            customerSocial.setName(user.getName());
            customerSocial.setPassword(bCryptPasswordEncoder.encode(secretPsw));

            appUser = appUserService.createCustomerSocial(customerSocial);
        }
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(appUser.getUsername());
        loginRequest.setPassword(secretPsw);
        return authenticateUser(loginRequest);
    }
}
