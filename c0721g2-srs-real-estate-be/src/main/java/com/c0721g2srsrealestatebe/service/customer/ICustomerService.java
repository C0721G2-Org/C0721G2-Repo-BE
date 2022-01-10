package com.c0721g2srsrealestatebe.service.customer;

import com.c0721g2srsrealestatebe.dto.CustomerDTO;
import com.c0721g2srsrealestatebe.model.customer.Customer;
import com.c0721g2srsrealestatebe.repository.customer.ICustomerRepository;

import java.util.Optional;

public interface ICustomerService {
    void editCustomer(CustomerDTO employeeEditDTO);
    Integer finByIdCard(String idCard);

}
