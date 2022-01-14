package com.c0721g2srsrealestatebe.repository.customer;

import com.c0721g2srsrealestatebe.model.account.AppUser;
import com.c0721g2srsrealestatebe.model.customer.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer, String> {
//    @Modifying
//    @Query(value = "INSERT INTO customers (customers.id,customers.address, customers.date_of_birth, " +
//            "customers.deleted, customers.email," +
//            " customers.gender,customers.id_card, customers.`name`, customers.phone_number," +
//            " customers.app_user_id, customers.image_id)" +
//            " VALUES :id,:address,:date_of_birth,:deleted,:email,:gender,id:card,:name,:phone_number)", nativeQuery = true)
//    Customer saveCustomer(@Param("address") String address, @Param("date_of_birth") String date_of_birth, @Param("deleted")
//            String deleted, @Param("email") String email, @Param("gender") String gender, @Param("id_card") String id_card, @Param("name") String name,
//                  @Param("phone_number") String phone_number);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO customers (customers.address, customers.date_of_birth, " +
            "customers.deleted, customers.email," +
            " customers.gender,customers.id_card, customers.`name`, customers.phone_number," +
            " customers.app_user_id, customers.image_id)" +
            " VALUES (:id,:address,:date_of_birth,:deleted,:email,:gender,:idCard,:name,:phone_number,:appUser)", nativeQuery = true)
    void save(@Param("address") String address, @Param("date_of_birth") LocalDate date_of_birth, @Param("deleted")
            Boolean deleted, @Param("email") String email, @Param("gender") Integer gender, @Param("idCard") String idCard, @Param("name") String name,
                      @Param("phone_number") String phone_number,@Param("appUser") AppUser appUser);


    @Query(value = "SELECT * FROM customers WHERE customers.id = :id", nativeQuery = true)
    Optional<Customer> findById(@Param("id") String id);
}
