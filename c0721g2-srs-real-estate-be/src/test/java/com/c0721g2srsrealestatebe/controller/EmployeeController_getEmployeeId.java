package com.c0721g2srsrealestatebe.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeController_getEmployeeId {

    @Autowired
    private MockMvc mockMvc;
    @Test
    public void getInfoEmployee_1() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/employee/edit", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getInfoEmployee_2() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/employee/edit", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void getInfoEmployee_3() throws Exception {

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/employee/edit/{id}", "NV-010"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getInfoEmployee_4() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/employee/edit/{id}", "NV-0006"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.id").value("NV-0006"))
                .andExpect(jsonPath("$.name").value("Trương Thị Hà Thư"))
                .andExpect(jsonPath("$.email").value("hathu@gmail.com"))
                .andExpect(jsonPath("$.phoneNumber").value("0911111111"))
                .andExpect(jsonPath("$.address").value("Quảng Bình"))
                .andExpect(jsonPath("$.dateOfBirth").value("1997-04-12"))
                .andExpect(jsonPath("$.idCard").value("197241502"))
                .andExpect(jsonPath("$.gender").value(0))
                .andExpect(jsonPath("$.degree.id").value(1))
                .andExpect(jsonPath("$.position.id").value(1))
                .andExpect(jsonPath("$.appUser").exists())
                .andExpect(jsonPath("$.image.id").value(1))
                .andExpect(jsonPath("$.deleted").value(Boolean.FALSE));
    }
}
