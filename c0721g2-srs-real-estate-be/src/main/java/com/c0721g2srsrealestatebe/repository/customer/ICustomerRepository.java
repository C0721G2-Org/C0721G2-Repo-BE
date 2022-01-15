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


@Transactional
public interface ICustomerRepository extends PagingAndSortingRepository<Customer, String>, JpaRepository<Customer, String> {
//    thienlb
    @Query(value = "select customers.id, customers.address, customers.date_of_birth,\n" +
            " customers.deleted, customers.email, customers.gender,\n" +
            " customers.`name`, customers.phone_number,  customers.app_user_id, \n" +
            " images.url, customers.image_id\n" +
            "from customers join images on customers.image_id = images.id\n" +
            "join app_users on customers.app_user_id = app_users.id\n" +
            "where customers.deleted = 0;", nativeQuery = true)
    Page<Customer> findAllCustomerByNative(Pageable pageable);

//thienlb - hien thi + search

    @Query(value = "select * from customers where customers.deleted = 0 and customers.`name` like concat('%',:name,'%') \n" +
            "and customers.phone_number like concat('%',:phone,'%') and customers.email like concat('%',:email,'%')", nativeQuery = true,
            countQuery = "select count(*) from customers \n" +
                    " where customers.deleted = 0 \n" +
                    "and customers.`name` like concat('%',:name,'%') \n" +
                    "and customers.phone_number like concat('%',:phone,'%') \n" +
                    "and customers.email like concat('%',:email,'%')")
    Page<Customer> findAllCustomerByNameAndPhoneAndEmail(@Param("name") String name,
                                                         @Param("phone") String phone,
                                                         @Param("email") String email,
                                                         @Param("page") Pageable pageable);

    // Xoa KH

    @Modifying
    @Transactional
    @Query(value = "update customers a set a.deleted= true where a.id = :id", nativeQuery = true)
    void updateCustomer(@Param("id") String id);


}
