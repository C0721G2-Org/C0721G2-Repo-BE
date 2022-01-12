package com.c0721g2srsrealestatebe.service.account;

import com.c0721g2srsrealestatebe.dto.AppUserDTO;
import com.c0721g2srsrealestatebe.model.account.AppUser;

public interface IAppUserService {
     void updatePassword(AppUserDTO appUserDTO);
     AppUser findAppUserByUserName(String id);
     String findPasswordByUsername(String username);

}
