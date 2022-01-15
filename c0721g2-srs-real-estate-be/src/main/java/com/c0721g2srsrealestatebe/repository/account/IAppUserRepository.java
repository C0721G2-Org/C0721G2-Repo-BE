package com.c0721g2srsrealestatebe.repository.account;

import com.c0721g2srsrealestatebe.model.account.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppUserRepository extends JpaRepository<AppUser, String> {

    Boolean existsByUsername(String username);

}
