package com.c0721g2srsrealestatebe.repository.customer;


import com.c0721g2srsrealestatebe.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findCustomerById(String id);

    @Transactional
    @Modifying
    @Query(value = "update customers as cs set cs.name = ?1, cs.date_of_birth ,cs.id_card = ?2, cs.address = ?3, " +
            "cs.phone_number = ?4, cs.app_user_id where cs.id = ?5", nativeQuery = true)
    void editCustomer(String name,String date_of_birth, String idCard, String address, String phoneNumber,String app_user_id, String id);

    @Query(value = "select count(id_card) from customers where id_card = ?", nativeQuery = true)
    Integer finByIdCard(String idCard);

    @Modifying
    @Query(value = "update app_users as ap set ap.password =?1 where ap.id=?2 ",nativeQuery = true)
    void saveNewPassword(String password,String id);
}