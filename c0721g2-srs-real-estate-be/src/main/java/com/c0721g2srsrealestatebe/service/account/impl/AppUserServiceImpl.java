package com.c0721g2srsrealestatebe.service.account.impl;

import com.c0721g2srsrealestatebe.Exception.AppUserException;
import com.c0721g2srsrealestatebe.dto.AppUserDTO;
import com.c0721g2srsrealestatebe.model.account.AppUser;
import com.c0721g2srsrealestatebe.repository.account.IAppUserRepository;
import com.c0721g2srsrealestatebe.service.account.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements IAppUserService {
    @Autowired
    IAppUserRepository iAppUserRepository;

    @Override
    public AppUser findAppUserByUserName(String id) {
        return iAppUserRepository.findAppUserByUsername(id).orElseThrow(() -> new AppUserException(
                "không thể tìm thấy id " + id + ""));
    }

    @Override
    public String findPasswordByUsername(String username) {
        System.out.println(username);
        System.out.println(iAppUserRepository.findPasswordByUsername(username));
        return iAppUserRepository.findPasswordByUsername(username);
    }


    @Override
    public void updatePassword(AppUserDTO appUserDTO) {
        iAppUserRepository.saveNewPassword(appUserDTO.getPassword(), appUserDTO.getUsername());

    }



}
