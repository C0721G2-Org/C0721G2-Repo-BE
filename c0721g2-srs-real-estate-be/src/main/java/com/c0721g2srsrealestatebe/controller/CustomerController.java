package com.c0721g2srsrealestatebe.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    //method nay dung de test junit test
    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public String testEndpoint() {
        return "Hello World!";
    }
}
