package com.c0721g2srsrealestatebe.controller;

import com.c0721g2srsrealestatebe.model.customer.Customer;
import com.c0721g2srsrealestatebe.service.customer.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(originPatterns = "http://localhost:4200")
@RequestMapping("api/customers")
public class CustomerController {
    @Autowired
    CustomerServiceImpl customerService;

    //thienlb - danh sach khach hang
//    @GetMapping("customer-list")
//    public ResponseEntity<Iterable<Customer>> showCustomer(
////            @RequestParam(defaultValue = "") String name,
////            @RequestParam(defaultValue = "") String phone,
////            @RequestParam(defaultValue = "") String email
//    )
//    {
//
////        if(name.equals("")
//        List<Customer> customers = (List<Customer>) customerService.findAllCustomer();
//        if (customers.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(customers, HttpStatus.OK);
//    }

//    thienlb - phan trang
        @GetMapping("customer-list")
    public ResponseEntity<Page<Customer>> showCustomer(@PageableDefault( sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        Page<Customer> customersPage = customerService.findCustomerPage(pageable);
        if(customersPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(customersPage, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable String id) {
        Optional<Customer> customerOptional = customerService.findCustomerById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.OK);
    }

    //thien-lb - tim khach hang by name
    @GetMapping("search-name/{name}")
    public ResponseEntity<Customer> findCustomerByName(@PathVariable String name) {
        Optional<Customer> customerOptional = customerService.findCustomerByName(name);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.OK);
    }

    //thienlb - tim khach hang by phone
    @GetMapping("search-phone/{phone}")
    public ResponseEntity<Customer> findCustomerByPhone(@PathVariable("phone") String phone) {
        System.out.println(phone);
        Optional<Customer> customerOptional = customerService.findCustomerByPhone(phone);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.OK);
    }

    //thienlb - tim khach hang by email
    @GetMapping("search-email/{email}")
    public ResponseEntity<Customer> findCustomerByEmail(@PathVariable String email) {
//        System.out.println(email);
        Optional<Customer> customerOptional = customerService.findCustomerByEmail(email);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.OK);
    }


//    @PostMapping
//    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
//        return new ResponseEntity<>(customerService.saveCustomer(customer), HttpStatus.CREATED);
//    }
//

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
