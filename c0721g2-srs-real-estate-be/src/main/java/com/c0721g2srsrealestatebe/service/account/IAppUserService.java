package com.c0721g2srsrealestatebe.service.account;

import com.c0721g2srsrealestatebe.model.account.AppUser;

public interface IAppUserService {
    void updatePassword(AppUser appUser);
    public AppUser findAppUserById(String id);

}
