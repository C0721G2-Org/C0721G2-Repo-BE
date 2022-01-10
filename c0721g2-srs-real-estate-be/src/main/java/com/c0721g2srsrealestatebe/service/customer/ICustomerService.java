package com.c0721g2srsrealestatebe.service.customer;

import com.c0721g2srsrealestatebe.model.customer.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    Iterable<Customer> findAll();

    Optional<Customer> findById(String id);

    Customer save(Customer customer);

    void remove(String id);

    List<Customer> searchByName(String name);
}
