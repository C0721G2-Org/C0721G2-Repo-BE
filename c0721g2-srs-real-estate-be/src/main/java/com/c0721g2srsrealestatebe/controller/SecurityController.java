package com.c0721g2srsrealestatebe.controller;

import com.c0721g2srsrealestatebe.jwt.JwtUtils;
import com.c0721g2srsrealestatebe.model.account.AppUser;
import com.c0721g2srsrealestatebe.payload.request.LoginRequest;
import com.c0721g2srsrealestatebe.payload.request.ResetPasswordRequest;
import com.c0721g2srsrealestatebe.payload.request.VerifyRequest;
import com.c0721g2srsrealestatebe.payload.response.JwtResponse;
import com.c0721g2srsrealestatebe.payload.response.MessageResponse;
import com.c0721g2srsrealestatebe.service.account.impl.AppUserServiceImpl;
import com.c0721g2srsrealestatebe.service.account.impl.MyUserDetailsImpl;
import com.c0721g2srsrealestatebe.service.account.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/public")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SecurityController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AppUserServiceImpl appUserService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                        loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        MyUserDetailsImpl myUserDetails = (MyUserDetailsImpl) authentication.getPrincipal();
        String jwtToken = jwtUtils.generateToken(myUserDetails);

        List<String> roles = myUserDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).collect(Collectors.toList());

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

}
