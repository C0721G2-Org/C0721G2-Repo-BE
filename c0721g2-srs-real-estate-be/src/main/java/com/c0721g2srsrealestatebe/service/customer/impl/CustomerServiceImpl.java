package com.c0721g2srsrealestatebe.service.customer.impl;

import com.c0721g2srsrealestatebe.Exception.UserNotFoundException;
import com.c0721g2srsrealestatebe.dto.AppUserDTO;
import com.c0721g2srsrealestatebe.dto.CustomerDTO;
import com.c0721g2srsrealestatebe.model.customer.Customer;
import com.c0721g2srsrealestatebe.repository.customer.ICustomerRepository;
import com.c0721g2srsrealestatebe.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements ICustomerService {
    ICustomerRepository iCustomerRepository;

    @Autowired
    public CustomerServiceImpl(ICustomerRepository customerRepository) {
        this.iCustomerRepository = customerRepository;
    }

    public Customer addCustomer(Customer customer){
        System.out.println("Add");
        return iCustomerRepository.save(customer);
    }

    public Customer findCustomerById(String id) {
        return iCustomerRepository.findCustomerById(id).orElseThrow(() -> new UserNotFoundException(
                "Customer with Id " + id + " was not found"));
    }

    @Override
    public void editCustomer(CustomerDTO customerDTO) {
        iCustomerRepository.editCustomer(customerDTO.getName(),customerDTO.getDateOfBirth().toString() ,customerDTO.getIdCard(),
                customerDTO.getAddress(), customerDTO.getPhoneNumber(),customerDTO.getAppUser().getId(), customerDTO.getId());
    }

    @Override
    public Integer finByIdCard(String idCard) {
        return null;
    }

    @Override
    public void savePassword(AppUserDTO appUserDTO) {
        iCustomerRepository.saveNewPassword(appUserDTO.getPassword(),appUserDTO.getUsername());
    }


}