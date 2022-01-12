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

    @PatchMapping(value = "/newpassword")
    public ResponseEntity<AppUser> update(@Valid @RequestBody AppUserDTO appUserDTO, BindingResult bindingResult) {
        try {
            new AppUserDTO().validate(appUserDTO, bindingResult);
            if (bindingResult.hasFieldErrors("password")) {
                System.out.println("mật nhập không đúng form");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            appUserDTO.setPassword(passwordEncoder.encode(appUserDTO.getPassword()));
            System.out.println(appUserDTO.getPassword());
            if (appUserDTO.getPassword().equals(iAppUserService.findPasswordByUsername(appUserDTO.getUsername()))){

                AppUser appUser = new AppUser();
                System.out.println(appUserDTO.toString());
                BeanUtils.copyProperties(appUserDTO, appUser);
                iAppUserService.updatePassword(appUserDTO);
                System.out.println("Đã lưu password");
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                System.out.println("nhập sai password");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }


}
