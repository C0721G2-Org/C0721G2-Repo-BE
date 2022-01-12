package com.c0721g2srsrealestatebe.repository.customer;


import com.c0721g2srsrealestatebe.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Transactional
public interface ICustomerRepository extends PagingAndSortingRepository<Customer, String>, JpaRepository<Customer, String> {
    @Query(value = "select customers.id, customers.address, customers.date_of_birth,\n" +
            " customers.deleted,  customers.email,  customers.gender,\n" +
            " customers.`name`, customers.phone_number,  customers.app_user_id, \n" +
            " images.url, customers.image_id\n" +
            "from customers join images on customers.image_id = images.id\n" +
            "join app_users on customers.app_user_id = app_users.id\n" +
            "where customers.deleted = 0;", nativeQuery = true)
    Iterable<Customer> findAllCustomerByNative();
//    @Query(value="select customers.id as id from customers", nativeQuery = true)
//    Iterable<Customer> findAll();

    @Query(value = "select * " +
            " from customers\n" +
            " where customers.deleted = 0 \n" +
            " and customers.`name` like concat('%',:name,'%') \n" +
            " and customers.phone_number like concat('%',:phone,'%')\n" +
            " and customers.email like concat('%',:email,'%')", nativeQuery = true)
    Page<Customer> findAllCustomerByNameAndPhoneAndEmail(@Param("name") String name,
                                                           @Param("phone") String phone,
                                                           @Param("email") String email,
                                                            Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = "update customers a set a.deleted= true where a.id = :id", nativeQuery = true)
    void updateCustomer(@Param("id") String id);
//
    @Query(value = "select customers.id, customers.address, customers.date_of_birth,customers.deleted,  \n" +
            "customers.email,  customers.gender, customers.`name`, customers.phone_number, \n" +
            " customers.app_user_id, images.url, customers.image_id from customers \n" +
            " join images on customers.image_id = images.id \n" +
            " join app_users on customers.app_user_id = app_users.id \n" +
            " where customers.deleted = 0 and customers.name =?1", nativeQuery = true)
    Optional<Customer> findCustomerByName(@Param("name") String name);
//
    @Query(value = "select customers.id, customers.address, customers.date_of_birth,customers.deleted,  \n" +
            "customers.email,  customers.gender, customers.`name`, customers.phone_number, \n" +
            " customers.app_user_id, images.url, customers.image_id from customers \n" +
            " join images on customers.image_id = images.id \n" +
            " join app_users on customers.app_user_id = app_users.id \n" +
            " where customers.deleted = 0 and customers.phone_number= ?1", nativeQuery = true)
    Optional<Customer> findCustomerByPhone(@Param("phone") String phone);


    @Query(value = "select customers.id, customers.address, customers.date_of_birth,customers.deleted,  \n" +
            "customers.email,  customers.gender, customers.`name`, customers.phone_number, \n" +
            " customers.app_user_id, images.url, customers.image_id from customers \n" +
            " join images on customers.image_id = images.id \n" +
            " join app_users on customers.app_user_id = app_users.id \n" +
            " where customers.deleted = 0 and customers.email= ?1", nativeQuery = true)
    Optional<Customer> findCustomerByEmail(@Param("email") String email);
}
