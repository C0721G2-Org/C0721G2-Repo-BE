package com.c0721g2srsrealestatebe.repository.account;


import com.c0721g2srsrealestatebe.model.account.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IAppUserRepository extends JpaRepository<AppUser,String> {
    Optional<AppUser> findAppUserByUsername(String id);


    @Modifying
    @Query(value = "update app_users as ap set ap.password =?1 where ap.username= ?2 ",nativeQuery = true)
    void saveNewPassword(String password,String username);

    @Query(value = "select real_estate_news.app_users.password from real_estate_news.app_users where real_estate_news.app_users.username = ?", nativeQuery = true)
    String findPasswordByUsername(String username);
}