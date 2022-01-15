package com.c0721g2srsrealestatebe.service.account.impl;

import com.c0721g2srsrealestatebe.repository.account.IAppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl {
    @Autowired
    IAppUserRepository iAppUserRepository;


    public Boolean existByUsername(String username) {
        return iAppUserRepository.existsByUsername(username);
    }

}
