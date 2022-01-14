package com.c0721g2srsrealestatebe.controller;


import com.c0721g2srsrealestatebe.dto.CustomerDTO;
import com.c0721g2srsrealestatebe.model.account.AppUser;
import com.c0721g2srsrealestatebe.model.account.Role;
import com.c0721g2srsrealestatebe.model.customer.Customer;
import com.c0721g2srsrealestatebe.repository.account.IAppUserRepository;
import com.c0721g2srsrealestatebe.service.account.impl.AppUserServiceImpl;
import com.c0721g2srsrealestatebe.service.customer.impl.CustomerServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    CustomerServiceImpl customerService;
    @Autowired
    AppUserServiceImpl appUserService;

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable String id) {
        Optional<Customer> customer = customerService.findById(id);
        if (!customer.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer.get(), HttpStatus.OK);
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveCustomer(@RequestBody @Valid CustomerDTO customerDTO, BindingResult bindingResult) {
//        new CustomerDTO().validate(customerDTO, bindingResult);
//        if (bindingResult.hasErrors()) {
//            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST);
//        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);


        Map<String,String> listErrors = new HashMap<>();


        //set role
        Role role = new Role();
        role.setId((long) 3);
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);

        // tạo account
        AppUser appUser = new AppUser();
        if (!appUserService.existsByUserName(customerDTO.getUserName())) {
           listErrors.put("errorUsername","Tài khoản đã được đăng kí");
            System.out.println(appUserService.existsByUserName(customerDTO.getUserName()));
        }
//        if (appUserService.existsByUserName2(appUser.getUsername()) != null) {
//            listErrors.put("errorUsername","Tài khoản đã được đăng kí ");
//        }
//        if (appUserService.existsByUserName3(appUser.getUsername())) {
//            listErrors.put("errorUsername","Tài khoản đã được đăng kí ");
//        }

        if(!listErrors.isEmpty()){
            return ResponseEntity.badRequest().body(listErrors);
        }

//        appUser.setUsername(appUser.getUsername());
//        appUser.setPassword(appUser.getPassword());
        appUser.setUsername(customerDTO.getUserName());
        appUser.setPassword(customerDTO.getPassword());
        appUser.setRoles(roleSet);

        customer.setAppUser(appUser);

        customerService.save(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }


    @GetMapping
    public ResponseEntity<Iterable<Customer>> showListCustomer() {
        List<Customer> customers = (List<Customer>) customerService.findAll();
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
}
