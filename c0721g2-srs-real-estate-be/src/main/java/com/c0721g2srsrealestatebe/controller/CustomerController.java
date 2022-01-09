package com.c0721g2srsrealestatebe.controller;

import com.c0721g2srsrealestatebe.model.customer.Customer;
import com.c0721g2srsrealestatebe.service.customer.impl.CustomerServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customerInformation")
public class CustomerController {
    private final CustomerServiceImpl customerService;

    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @GetMapping("id/{id}")
    public ResponseEntity<Customer> showId(@PathVariable("id") String id) {
        System.out.println("showoff");
        Customer customer = customerService.findCustomerById(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

//    @RequestMapping(value = "/add", method = RequestMethod.POST
//            consumes = MediaType.APPLICATION_JSON_VALUE,
//           produces = MediaType.APPLICATION_JSON_VALUE
//            )
//    public ResponseEntity<Customer> add(@RequestBody Customer customer) {
//        Customer customerAdd=customerService.addCustomer(customer);
//        return new ResponseEntity<>(customerAdd,HttpStatus.OK);
//    }



    @PutMapping(value = "/update", consumes = {"application/json","application/xml"})
    public ResponseEntity<Customer> update(@RequestBody Customer customer) {
        Customer customerUpdate = customerService.addCustomer(customer);
        return new ResponseEntity<>(customerUpdate,HttpStatus.OK);
    }
}
