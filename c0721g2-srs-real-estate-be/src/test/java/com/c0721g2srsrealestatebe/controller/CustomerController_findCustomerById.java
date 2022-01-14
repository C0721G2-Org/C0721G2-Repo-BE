//package com.c0721g2srsrealestatebe.controller;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class CustomerController_findCustomerById {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    public void findCustomerById_4() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders.get("/api/customer/{id}","KH-0011"))
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful())
//                .andExpect(jsonPath("$.id").value("KH-0011"))
//                .andExpect(jsonPath("$.name").value("Lê Quốc Tùng"))
//                .andExpect(jsonPath("$.email").value("quoctung@gmail.com"))
//                .andExpect(jsonPath("$.phoneNumber").value("0905123321"))
//                .andExpect(jsonPath("$.idCard").value("197241502"))
//                .andExpect(jsonPath("$.gender").value(0))
//                .andExpect(jsonPath("$.address").value("Đà Nẵng"))
//                .andExpect(jsonPath("$.dateOfBirth").value("1997-02-12"))
//                .andExpect(jsonPath("$.appUser").value("159c674c-d64c-4649-abc0-68564e05dfa0"));
//    }
//    @Test
//    public void findCustomerById_1() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders.get("/api/customer/{id}","null"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//
//    }
//    @Test
//    public void findCustomerById_2() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders.get("/api/customer/{id}",""))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//
//    }
//    @Test
//    public void findCustomerById_3() throws Exception {
//        this.mockMvc.perform(
//                MockMvcRequestBuilders.get("/api/customer/{id}","abc123"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//
//    }
//}
