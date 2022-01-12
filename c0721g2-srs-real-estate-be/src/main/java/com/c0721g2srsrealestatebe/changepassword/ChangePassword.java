package com.c0721g2srsrealestatebe.changepassword;
import com.c0721g2srsrealestatebe.model.account.AppUser;

import com.c0721g2srsrealestatebe.service.account.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/updatePassword")
public class ChangePassword {
    @Autowired
    IAppUserService iAppUserService;

    @GetMapping("/idUser/{id}")
    public ResponseEntity<AppUser> findUserApp(@RequestBody AppUser appUser,@PathVariable String id){
        iAppUserService.findAppUserById(id);
        System.out.println("layj honf "+appUser.toString());
        return new ResponseEntity<>(appUser,HttpStatus.OK);
    }

    @PatchMapping("/updating/{id}")
    public ResponseEntity<AppUser> UpdatePassword(@RequestBody AppUser appUser, @PathVariable String id) {
        iAppUserService.updatePassword(appUser);
        String check= iAppUserService.findAppUserById(id).getId();
        System.out.println(check);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
