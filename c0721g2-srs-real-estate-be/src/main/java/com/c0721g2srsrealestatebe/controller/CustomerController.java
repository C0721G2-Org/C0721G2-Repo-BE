package com.c0721g2srsrealestatebe.controller;

import com.c0721g2srsrealestatebe.dto.AppUserDTO;
import com.c0721g2srsrealestatebe.dto.CustomerDTO;
import com.c0721g2srsrealestatebe.model.account.AppUser;
import com.c0721g2srsrealestatebe.model.customer.Customer;
import com.c0721g2srsrealestatebe.service.customer.impl.CustomerServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

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

    @PutMapping(value = "/update", consumes = {"application/json", "application/xml"})
    public ResponseEntity<Customer> update(@Valid @RequestBody CustomerDTO customerDTO, BindingResult bindingResult) {
        new CustomerDTO().validate(customerDTO, bindingResult);
        if (bindingResult.hasFieldErrors("name")){
            System.out.println("tên bạn nhập không đúng");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else if (bindingResult.hasFieldErrors("idCard")){
            System.out.println("card bạn nhập không đúng");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        customerDTO.toString();
        Customer customer1=new Customer();
        System.out.println(customerDTO.toString());
        BeanUtils.copyProperties(customerDTO,customer1);
        customerService.addCustomer(customer1);
        return new ResponseEntity<>(customer1,HttpStatus.OK);
    }
    @PutMapping(value = "/newpassword")
    public ResponseEntity<AppUser>update(@Valid @RequestBody AppUserDTO appUserDTO, BindingResult bindingResult){
        new AppUserDTO().validate(appUserDTO,bindingResult);
        if (bindingResult.hasFieldErrors("password")){
            System.out.println("mật nhập không đúng");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        AppUser appUser=new AppUser();
        System.out.println(appUserDTO.toString());
        BeanUtils.copyProperties(appUserDTO,appUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}