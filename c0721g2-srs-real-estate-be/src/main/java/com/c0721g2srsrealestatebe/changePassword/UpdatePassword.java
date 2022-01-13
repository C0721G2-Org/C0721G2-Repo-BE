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

@RestController
@RequestMapping("/account")
public class UpdatePassword {
    @Autowired
    IAppUserService iAppUserService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @PatchMapping(value = "/newpassword/{Pass}")
    public ResponseEntity<AppUser> update(@Valid @RequestBody AppUserDTO appUserDTO,
                                          @PathVariable String Pass, BindingResult bindingResult) {
        try {
            new AppUserDTO().validate(appUserDTO, bindingResult);
            if (bindingResult.hasFieldErrors("password")) {
                System.out.println("mật nhập không đúng form");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            System.out.println("pass cũ người dùng nhập sai");
            System.out.println(appUserDTO.getPassword());
            System.out.println("pass mới");
            System.out.println(Pass);
            if (passwordEncoder.matches(
                            iAppUserService.findPasswordByUsername(appUserDTO.getUsername()),appUserDTO.getPassword())
                            && Pass != appUserDTO.getPassword()){
                AppUserDTO appUser = new AppUserDTO();
                String newPassword = passwordEncoder.encode(Pass);
                System.out.println(newPassword);
                appUser.setUsername(appUserDTO.getUsername());
                appUser.setPassword(newPassword);
                update(appUser);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            else {
                System.out.println("nhập sai password");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PostMapping("/updatedcontroller")
    public ResponseEntity<AppUser> update(@RequestBody AppUserDTO password) {
        try {
            iAppUserService.updatePassword(password);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
