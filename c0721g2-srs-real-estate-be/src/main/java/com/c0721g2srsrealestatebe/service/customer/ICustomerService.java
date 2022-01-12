package com.c0721g2srsrealestatebe.service.customer;

import com.c0721g2srsrealestatebe.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ICustomerService {
    Iterable<Customer> findAllCustomer();

    Optional<Customer> findCustomerById(String id);

    Customer saveCustomer(Customer customer);

    void removeCustomer(String id);

    Page<Customer> findCustomerPage(Pageable pageable);

    Optional<Customer> findCustomerByName(String name);
    Optional<Customer> findCustomerByPhone(String phone);

    Optional<Customer> findCustomerByEmail(String email);

    Page<Customer> findAllCustomerByNameAndPhoneAndEmailPage(String name, String phone, String email, Pageable pageable);
}
