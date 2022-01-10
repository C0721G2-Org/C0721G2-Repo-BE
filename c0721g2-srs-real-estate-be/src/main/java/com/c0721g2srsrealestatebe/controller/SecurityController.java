package com.c0721g2srsrealestatebe.controller;

import com.c0721g2srsrealestatebe.jwt.JwtUtils;
import com.c0721g2srsrealestatebe.model.account.AppUser;
import com.c0721g2srsrealestatebe.payload.request.LoginRequest;
import com.c0721g2srsrealestatebe.payload.request.ResetPasswordRequest;
import com.c0721g2srsrealestatebe.payload.response.JwtResponse;
import com.c0721g2srsrealestatebe.payload.response.MessageResponse;
import com.c0721g2srsrealestatebe.service.account.impl.AppUserServiceImpl;
import com.c0721g2srsrealestatebe.service.account.impl.MyUserDetailsImpl;
import com.c0721g2srsrealestatebe.service.account.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;
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
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                        loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        MyUserDetailsImpl myUserDetails = (MyUserDetailsImpl) authentication.getPrincipal();
        String jwtToken = jwtUtils.generateToken(myUserDetails);

        List<String> roles = myUserDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwtToken,myUserDetails.getUsername(),roles));

    }

    @PostMapping("/reset-password")
    public ResponseEntity<?> reset(@RequestBody LoginRequest loginRequest) throws MessagingException, UnsupportedEncodingException {

        if (appUserService.existsUserByEmail(loginRequest.getEmail())) {
            appUserService.addVerificationCode(loginRequest.getEmail());
            return ResponseEntity.ok(new MessageResponse("Sent email"));
        }
        return ResponseEntity
                .badRequest()
                .body(new MessageResponse("Tài khoản không tồn tại"));
    }

    @PostMapping("/do-reset-password")
    public ResponseEntity<?> doResetPassword(@RequestBody ResetPasswordRequest resetPassRequest) {
        appUserService.saveNewPassword(bCryptPasswordEncoder.encode(resetPassRequest.getPassword()), resetPassRequest.getCode());
        return ResponseEntity.ok(new MessageResponse("success"));
    }
}
