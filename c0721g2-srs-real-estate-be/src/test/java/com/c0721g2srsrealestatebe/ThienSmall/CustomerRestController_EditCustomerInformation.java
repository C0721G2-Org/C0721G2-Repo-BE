package com.c0721g2srsrealestatebe.ThienSmall;

import com.c0721g2srsrealestatebe.dto.AppUserDTO;
import com.c0721g2srsrealestatebe.dto.CustomerDTO;
import com.c0721g2srsrealestatebe.model.customer.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.time.Month;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerRestController_EditCustomerInformation {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void edit_Customer_Successful() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId("KH-0002");
        customerDTO.setName("thien");
        customerDTO.setAddress("dfiohbkldfgn");
        customerDTO.setPhoneNumber("0905032032");
        customerDTO.setIdCard("001234567532");
        customerDTO.setEmail("fwejhfjkaef@gmail.com");
        customerDTO.setGender(0);
        customerDTO.setDeleted(false);
        LocalDate time = LocalDate.of(2000, Month.AUGUST, 5);
        customerDTO.setDateOfBirth(time);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/customerInformation/update")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
 @Test
    public void edit_Customer_withoutName() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId("KH-0002");
        customerDTO.setName("");
        customerDTO.setAddress("dfiohbkldfgn");
        customerDTO.setPhoneNumber("0905032032");
        customerDTO.setIdCard("001234567532");
        customerDTO.setEmail("fwejhfjkaef@gmail.com");
        customerDTO.setGender(0);
        customerDTO.setDeleted(false);
        LocalDate time = LocalDate.of(2000, Month.AUGUST, 5);
        customerDTO.setDateOfBirth(time);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/customerInformation/update")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void edit_Customer_NamehasNumber() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId("KH-0002");
        customerDTO.setName("nguyễn văn thẹo 123");
        customerDTO.setAddress("dfiohbkldfgn");
        customerDTO.setPhoneNumber("0905032032");
        customerDTO.setIdCard("001234567532");
        customerDTO.setEmail("fwejhfjkaef@gmail.com");
        customerDTO.setGender(0);
        customerDTO.setDeleted(false);
        LocalDate time = LocalDate.of(2000, Month.AUGUST, 5);
        customerDTO.setDateOfBirth(time);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/customerInformation/update")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void edit_Customer_PhonehasText() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId("KH-0002");
        customerDTO.setName("nguyễn văn thẹo 123");
        customerDTO.setAddress("dfiohbkldfgn");
        customerDTO.setPhoneNumber("09050ấda032");
        customerDTO.setIdCard("001234567532");
        customerDTO.setEmail("fwejhfjkaef@gmail.com");
        customerDTO.setGender(0);
        customerDTO.setDeleted(false);
        LocalDate time = LocalDate.of(2000, Month.AUGUST, 5);
        customerDTO.setDateOfBirth(time);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/customerInformation/update")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
 @Test
    public void edit_Customer_Wrong_idCard() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId("KH-0002");
        customerDTO.setName("nguyễn văn thẹo 123");
        customerDTO.setAddress("dfiohbkldfgn");
        customerDTO.setPhoneNumber("09050ấda032");
        customerDTO.setIdCard("001234532ádasd");
        customerDTO.setEmail("fwejhfjkaef@gmail.com");
        customerDTO.setGender(0);
        customerDTO.setDeleted(false);
        LocalDate time = LocalDate.of(2000, Month.AUGUST, 5);
        customerDTO.setDateOfBirth(time);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/customerInformation/update")
                        .content(this.objectMapper.writeValueAsString(customerDTO))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findcustomerbyid() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/customerInformation/id/{}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findcustomerbyid_2() throws Exception {
//Data ở expect không khớp vối dưới database ===>bị lỗi
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/customerInformation/id/{id}", "KH-0002"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.id").value("KH-0002"))
                .andExpect(jsonPath("$.name").value("thien"))
                .andExpect(jsonPath("$.dateOfBirth").value("2000-7-14"))
                .andExpect(jsonPath("$.gender").value(1))
                .andExpect(jsonPath("$.Email").value("uihfefawe@gmail.com"))
                .andExpect(jsonPath("$.idCard").value("012321546386"))
                .andExpect(jsonPath("$.Gender").value(0))
                .andExpect(jsonPath("$.PhoneNumber").value("0905098765"));
    }
@Test
    public void findcustomerbyid_notexist() throws Exception {
//Data ở expect không khớp vối dưới database ===>bị lỗi
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/customerInformation/id/{id}", "KH-002"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    void editPassword() throws Exception {
        AppUserDTO appUserDTO = new AppUserDTO();
        appUserDTO.setPassword("Thien153");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/customerInformation/newpassword")
                        .content(this.objectMapper.writeValueAsString(appUserDTO))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}



