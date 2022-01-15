package com.c0721g2srsrealestatebe.service.customer;

import com.c0721g2srsrealestatebe.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ICustomerService {
    Page<Customer> findAllCustomer(Pageable pageable);

//  thienlb
    Optional<Customer> findCustomerById(String id);

    Customer saveCustomer(Customer customer);

//  thienlb
    void removeCustomer(String id);

    Page<Customer> findCustomerPage(Pageable pageable);


// thienlb
    Page<Customer> findAllCustomerByNameAndPhoneAndEmailPage(String name, String phone, String email, Pageable pageable);
}
