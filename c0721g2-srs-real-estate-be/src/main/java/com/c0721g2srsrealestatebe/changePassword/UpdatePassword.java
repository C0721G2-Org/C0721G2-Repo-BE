package com.c0721g2srsrealestatebe.changePassword;

import com.c0721g2srsrealestatebe.dto.AppUserDTO;
import com.c0721g2srsrealestatebe.model.account.AppUser;
import com.c0721g2srsrealestatebe.service.account.IAppUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@CrossOrigin(value = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/account")
public class UpdatePassword {
    @Autowired
    IAppUserService iAppUserService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/userName/{userName}")
    public ResponseEntity<AppUser> update(@PathVariable String userName) {
        try {
            AppUser appUser = iAppUserService.findAppUserByUserName(userName);
            System.out.println(userName);
            return new ResponseEntity<>(appUser, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PatchMapping(value = "/newpassword/{pass}")
    public ResponseEntity<AppUser> update(@Valid @RequestBody AppUserDTO appUserDTO,
                                          @PathVariable String pass, BindingResult bindingResult) {
        try {
            new AppUserDTO().validate(appUserDTO, bindingResult);
            if (bindingResult.hasFieldErrors("password")) {
                System.out.println("mật nhập không đúng form");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            if (passwordEncoder.matches(
                    iAppUserService.findPasswordByUsername(appUserDTO.getUsername()), appUserDTO.getPassword())
                    &&pass!=iAppUserService.findPasswordByUsername(appUserDTO.getUsername())) {
                AppUserDTO appUser = new AppUserDTO();
                pass=passwordEncoder.encode(pass);
                //String newPassword = passwordEncoder.encode(appUserDTO.getPassword());
                System.out.println(pass);
                //appUser.setUsername(appUserDTO.getUsername());
                appUser.setPassword(pass);
                update(appUser);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                System.out.println("nhập sai password");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<AppUser> update(@RequestBody AppUserDTO password) {
        try {
            iAppUserService.updatePassword(password);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
