package com.c0721g2srsrealestatebe.repository.account;


import com.c0721g2srsrealestatebe.model.account.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface IAppUserRepository extends JpaRepository<AppUser,String> {
    Optional<AppUser> findAppUserByUsername(String id);


    @Modifying
    @Query(value = "update app_users set password =?1 where username= ?2 ",nativeQuery = true)
    void saveNewPassword(String password,String username);

    @Query(value = "select real_estate_news.app_users.password from real_estate_news.app_users where real_estate_news.app_users.username = ?", nativeQuery = true)
    String findPasswordByUsername(String username);
}