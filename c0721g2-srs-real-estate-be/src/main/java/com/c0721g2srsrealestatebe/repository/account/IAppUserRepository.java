package com.c0721g2srsrealestatebe.repository.account;

import com.c0721g2srsrealestatebe.model.account.AppUser;
import com.c0721g2srsrealestatebe.model.customer.Customer;
import com.sun.org.apache.xpath.internal.objects.XBoolean;
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
    boolean existsByUsername(String username);


        @Query(value = "SELECT * \n" +
            " FROM app_users\n" +
            " WHERE EXISTS (SELECT * \n" +
            " WHERE app_users.username = :username)", nativeQuery = true)
    boolean existsByUsername2(@Param("username") String username);

//    @Query(value = "select app_users.username from app_users where username = :username", nativeQuery = true)
//    String existsByUsername(String username);


    @Modifying
    @Query(value = "insert into app_users(username,password) values (:username,:password)", nativeQuery = true)
    void addNewAccount(String username, String password);


//    @Query(value = "SELECT * FROM customers WHERE customers.id = :id", nativeQuery = true)
//    Optional<Customer> findById(@Param("id") String id);

}
