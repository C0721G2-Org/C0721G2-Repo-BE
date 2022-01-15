package com.c0721g2srsrealestatebe.repository.customer;

import com.c0721g2srsrealestatebe.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,String> {
    @Query(value="select customers.id, customers.address, customers.date_of_birth,\n" +
            " customers.deleted,  customers.email,  customers.gender,\n" +
            " customers.`name`, customers.phone_number,  customers.app_user_id, \n" +
            " images.url, customers.image_id\n" +
            "from customers join images on customers.image_id = images.id\n" +
            "join app_users on customers.app_user_id = app_users.id\n" +
            "where customers.deleted = 0;", nativeQuery = true)
    Iterable<Customer> findAllCustomerByNative();
//    @Query(value="select customers.id as id from customers", nativeQuery = true)
//    Iterable<Customer> findAll();

    @Modifying
    @Transactional
    @Query(value= "update customers a set a.deleted= true where a.id = :id" ,nativeQuery=true)
    void updateCustomer(@Param("id") String id);

    @Query(value="select customers.id, customers.address, customers.date_of_birth,customers.deleted,  \n" +
            "customers.email,  customers.gender, customers.`name`, customers.phone_number, \n" +
            " customers.app_user_id, images.url, customers.image_id from customers \n" +
            " join images on customers.image_id = images.id \n" +
            " join app_users on customers.app_user_id = app_users.id \n" +
            " where customers.deleted = 0 and customers.name =?1", nativeQuery =true)
    Optional<Customer> findCustomerByName(@Param("name") String name);

    @Query(value="select customers.id, customers.address, customers.date_of_birth,customers.deleted,  \n" +
            "customers.email,  customers.gender, customers.`name`, customers.phone_number, \n" +
            " customers.app_user_id, images.url, customers.image_id from customers \n" +
            " join images on customers.image_id = images.id \n" +
            " join app_users on customers.app_user_id = app_users.id \n" +
            " where customers.deleted = 0 and customers.phone_number= ?1", nativeQuery =true)
    Optional<Customer> findCustomerByPhone(@Param("phone") String phone);


    @Query(value="select customers.id, customers.address, customers.date_of_birth,customers.deleted,  \n" +
            "customers.email,  customers.gender, customers.`name`, customers.phone_number, \n" +
            " customers.app_user_id, images.url, customers.image_id from customers \n" +
            " join images on customers.image_id = images.id \n" +
            " join app_users on customers.app_user_id = app_users.id \n" +
            " where customers.deleted = 0 and customers.email= ?1", nativeQuery =true)
    Optional<Customer> findCustomerByEmail(@Param("email") String email);
}
