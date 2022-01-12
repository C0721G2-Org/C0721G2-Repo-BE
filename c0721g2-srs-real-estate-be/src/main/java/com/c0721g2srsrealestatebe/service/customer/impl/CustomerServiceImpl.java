package com.c0721g2srsrealestatebe.service.customer.impl;

import com.c0721g2srsrealestatebe.model.customer.Customer;
import com.c0721g2srsrealestatebe.repository.customer.ICustomerRepository;
import com.c0721g2srsrealestatebe.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    ICustomerRepository iCustomerRepository;

    @Override
    public Iterable<Customer> findAllCustomer() {
        return iCustomerRepository.findAllCustomerByNative();
    }

    @Override
    public Optional<Customer> findCustomerById(String id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return iCustomerRepository.save(customer);
    }

    @Override
    public void removeCustomer(String id) {
//        iCustomerRepository.deleteById(id);
        iCustomerRepository.updateCustomer(id);
    }

    @Override
    public Page<Customer> findCustomerPage(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);
    }

    @Override
    public Optional<Customer> findCustomerByName(String name) {
        return iCustomerRepository.findCustomerByName(name);
    }

    @Override
    public Optional<Customer> findCustomerByPhone(String phone) {
        return iCustomerRepository.findCustomerByPhone(phone);
    }

    @Override
    public Optional<Customer> findCustomerByEmail(String email) {
        return iCustomerRepository.findCustomerByEmail(email);
    }

    @Override
    public Page<Customer> findAllCustomerByNameAndPhoneAndEmailPage(String name, String phone, String email, Pageable pageable) {
        return iCustomerRepository.findAllCustomerByNameAndPhoneAndEmail(name, phone, email, pageable);
    }

}
