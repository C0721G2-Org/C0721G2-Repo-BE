package com.c0721g2srsrealestatebe.controller;


import com.c0721g2srsrealestatebe.dto.AppUserDTO;
import com.c0721g2srsrealestatebe.dto.CustomerDTO;
import com.c0721g2srsrealestatebe.model.account.AppUser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerController_createCustomer {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createCustomer_18() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId("KH-0001234");
        customerDTO.setName("David");
        customerDTO.setAddress("USA");
        customerDTO.setIdCard("0912345678");
        customerDTO.setGender(1);
        customerDTO.setPhoneNumber("094564654");
        customerDTO.setEmail("david@gmail.com");


//        AppUserDTO appUserDTO = new AppUserDTO();
//        appUserDTO.setId("159c674c-d64c-4649-abc0-68564e05dfa0");
//        customerDTO.setAppUserDTO(appUserDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/customer/create")
                .content(this.objectMapper.writeValueAsString(customerDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void createCustomer_17() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        // tên dưới 1 kí tự
        customerDTO.setName("a");
        customerDTO.setAddress("USA");
        customerDTO.setIdCard("0905687462");
        customerDTO.setGender(1);
        customerDTO.setAddress("Đn");
        customerDTO.setPhoneNumber("09");
        customerDTO.setEmail("david@gmail.com");


        AppUserDTO appUserDTO = new AppUserDTO();
        appUserDTO.setId("159c674c-d64c-4649-abc0-68564e05dfa0");
        customerDTO.setAppUserDTO(appUserDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/customer/create")
                .content(this.objectMapper.writeValueAsString(customerDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createCustomer_16() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName("David");
        customerDTO.setAddress("USA");
        // id card dài hơn 12 kí tự
        customerDTO.setIdCard("09844566453453453453");
        customerDTO.setGender(1);
        customerDTO.setAddress("Đn");
        customerDTO.setPhoneNumber("094564654");
        customerDTO.setEmail("david@gmail.com");


        AppUserDTO appUserDTO = new AppUserDTO();
        appUserDTO.setId("159c674c-d64c-4649-abc0-68564e05dfa0");
        customerDTO.setAppUserDTO(appUserDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/customer/create")
                .content(this.objectMapper.writeValueAsString(customerDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    @Test
    public void createCustomer_15() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName("David");
        customerDTO.setAddress("USA");
        customerDTO.setIdCard("12344684");
        customerDTO.setGender(1);
        customerDTO.setAddress("Đn");
        // sai format
        customerDTO.setPhoneNumber("094564654abc");
        customerDTO.setEmail("david@gmail.com");


        AppUserDTO appUserDTO = new AppUserDTO();
        appUserDTO.setId("159c674c-d64c-4649-abc0-68564e05dfa0");
        customerDTO.setAppUserDTO(appUserDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/customer/create")
                .content(this.objectMapper.writeValueAsString(customerDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createCustomer_14() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName("David");
        customerDTO.setAddress("USA");
        // để rỗng
        customerDTO.setIdCard("");
        customerDTO.setGender(1);
        customerDTO.setAddress("Đn");
        customerDTO.setPhoneNumber("094564654");
        customerDTO.setEmail("david@gmail.com");


        AppUserDTO appUserDTO = new AppUserDTO();
        appUserDTO.setId("159c674c-d64c-4649-abc0-68564e05dfa0");
        customerDTO.setAppUserDTO(appUserDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/customer/create")
                .content(this.objectMapper.writeValueAsString(customerDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createCustomer_13() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName("David");
        customerDTO.setAddress("USA");
        customerDTO.setIdCard("6546545");
        // để null
        customerDTO.setGender(null);
        customerDTO.setAddress("Đn");
        customerDTO.setPhoneNumber("094564654");
        customerDTO.setEmail("david@gmail.com");


        AppUserDTO appUserDTO = new AppUserDTO();
        appUserDTO.setId("159c674c-d64c-4649-abc0-68564e05dfa0");
        customerDTO.setAppUserDTO(appUserDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/customer/create")
                .content(this.objectMapper.writeValueAsString(customerDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
