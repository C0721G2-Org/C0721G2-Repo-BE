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
    @Query(value = "update customers as cs set cs.name = ?1, cs.date_of_birth =?2 ,cs.id_card = ?3, cs.address = ?4, " +
            "cs.phone_number = ?5, cs.app_user_id =?6 where cs.id = ?7", nativeQuery = true)
    void editCustomer(String name,String date_of_birth, String idCard, String address, String phoneNumber,String app_user_id, String id);

    @Query(value = "select count(id_card) from customers where id_card = ?", nativeQuery = true)
    Integer finByIdCard(String idCard);


}