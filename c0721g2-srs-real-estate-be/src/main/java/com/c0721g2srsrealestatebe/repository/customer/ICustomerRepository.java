package com.c0721g2srsrealestatebe.repository.customer;

import com.c0721g2srsrealestatebe.model.customer.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer, String> {
    @Modifying
    @Query(value = "INSERT INTO customers (customers.id,customers.address, customers.date_of_birth, " +
            "customers.deleted, customers.email," +
            " customers.gender,customers.id_card, customers.`name`, customers.phone_number," +
            " customers.app_user_id, customers.image_id)" +
            " VALUES :id,:address,:date_of_birth,:deleted,:email,:gender,id:card,:name,:phone_number)", nativeQuery = true)
    Customer save(@Param("id") String id, @Param("address") String address, @Param("date_of_birth") String date_of_birth, @Param("deleted")
            String deleted, @Param("email") String email, @Param("gender") String gender, @Param("id_card") String id_card, @Param("name") String name,
                  @Param("phone_number") String phone_number);


    @Query(value = "SELECT * FROM customers WHERE customers.id = :id", nativeQuery = true)
    Optional<Customer> findById(@Param("id") String id);

}
//    @Query("select u from UserEntity u where u.userId = :userId")
//    UserEntity getUserEntityById(@Param("userId") String userId);


//    @Query("insert into Person (id,name,age) select :id,:name,:age from Dual")
//    public int modifyingQu