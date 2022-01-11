package com.c0721g2srsrealestatebe.repository.customer;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IAppUserRepository {
//    @Query(value = "select username from app_users where username =?1", nativeQuery = true)
//    String existsByUserName(String username);
//
//    @Modifying
//    @Query(value = "insert into app_users(username,password) values (?1,?2)", nativeQuery = true)
//    void addNewAccount(String username, String password);
}
