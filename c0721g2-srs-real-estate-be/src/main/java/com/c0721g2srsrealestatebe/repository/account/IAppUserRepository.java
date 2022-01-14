package com.c0721g2srsrealestatebe.repository.account;

import com.c0721g2srsrealestatebe.model.account.AppUser;
import com.c0721g2srsrealestatebe.model.customer.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAppUserRepository extends PagingAndSortingRepository<AppUser, String> {
//    @Query(value = "SELECT * \n" +
//            "FROM app_users\n" +
//            "WHERE EXISTS (SELECT * \n" +
//            "              WHERE app_users.username = :username)", nativeQuery = true)
    Boolean existsByUsername(@Param("username") String username);

    @Query(value = "SELECT * \n" +
            "FROM app_users\n" +
            "WHERE EXISTS (SELECT * \n" +
            "              WHERE app_users.username = :username)", nativeQuery = true)
    String existsByUsername2(@Param("username") String username);

    @Query(value = "SELECT * FROM app_users\n" +
            "where username = :username)", nativeQuery = true)
    String existsByUsername3(@Param("username") String username);


    @Modifying
    @Query(value = "insert into app_users(username,password) values (:username,:password)", nativeQuery = true)
    void addNewAccount(String username, String password);


//    @Query(value = "SELECT * FROM customers WHERE customers.id = :id", nativeQuery = true)
//    Optional<Customer> findById(@Param("id") String id);

}
