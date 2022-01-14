package com.c0721g2srsrealestatebe.service.account.impl;

import com.c0721g2srsrealestatebe.model.account.AppUser;
import com.c0721g2srsrealestatebe.repository.account.IAppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserServiceImpl {
    @Autowired
    IAppUserRepository iAppUserRepository;


    public boolean existsByUserName(String username) {
        return iAppUserRepository.existsByUsername(username);
    }

    public String existsByUserName2(String username) {
        return iAppUserRepository.existsByUsername2(username);
    }

    public String existsByUserName3(String username) {
        return iAppUserRepository.existsByUsername3(username);
    }

    public Optional<AppUser> findUserName(String id) {
        return iAppUserRepository.findById(id);
    }
}
//    public Optional<Customer> findById(String id) {
////        return iCustomerRepository.findById(id);
////    }