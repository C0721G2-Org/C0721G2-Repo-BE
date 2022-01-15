package com.c0721g2srsrealestatebe.controller;

import com.c0721g2srsrealestatebe.model.customer.Customer;
import com.c0721g2srsrealestatebe.service.customer.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(originPatterns = "http://localhost:4200")
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    CustomerServiceImpl customerService;


    //    thienlb - phan trang
    @GetMapping("customer-list-test")
    public ResponseEntity<Page<Customer>> showCustomer(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Customer> customersPage = customerService.findCustomerPage(pageable);
        if (customersPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(customersPage, HttpStatus.OK);
    }

    //    ThienLb - tim kiem + phan trang
    @GetMapping("/customer-list")
    public ResponseEntity<Page<Customer>> findCustomerByPhoneAndNameAndEmail(
            @RequestParam(defaultValue = "") String name,
            @RequestParam(defaultValue = "") String phone,
            @RequestParam(defaultValue = "") String email,
            @RequestParam(defaultValue = "0") int page
    ) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by("id"));
        Page<Customer> customersNewPage = customerService.findAllCustomerByNameAndPhoneAndEmailPage(name, phone, email, pageable);

        if (customersNewPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customersNewPage, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable String id) {
        Optional<Customer> customerOptional = customerService.findCustomerById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.OK);
    }

    //thienlb-xoa khach hang
    @DeleteMapping("delete-customer/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable String id) {
        Optional<Customer> customerOptional = customerService.findCustomerById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerService.removeCustomer(id);
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.NO_CONTENT);
    }

}
