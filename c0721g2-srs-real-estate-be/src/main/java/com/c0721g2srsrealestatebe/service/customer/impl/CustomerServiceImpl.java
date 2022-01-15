package com.c0721g2srsrealestatebe.service.customer.impl;


import com.c0721g2srsrealestatebe.dto.CustomerDTO;
import com.c0721g2srsrealestatebe.model.customer.Customer;
import com.c0721g2srsrealestatebe.repository.customer.ICustomerRepository;
import com.c0721g2srsrealestatebe.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    ICustomerRepository iCustomerRepository;


    @Override
    public Iterable<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(String id) {
        return iCustomerRepository.findById(id);
    }


    public Customer save(Customer customer) {
        return iCustomerRepository.save(customer);
    }


//    public void saveCustomerDTO(CustomerDTO customerDTO) {
//        iCustomerRepository.saveCustomer(customerDTO.getAddress(), customerDTO.getDateOfBirth(), false,
//                customerDTO.getEmail(), customerDTO.getGender(), customerDTO.getIdCard(), customerDTO.getName(),
//                customerDTO.getPhoneNumber());
//    }


    @Override
    public void remove(String id) {

    }

    @Override
    public List<Customer> searchByName(String name) {
        return null;
    }
}
