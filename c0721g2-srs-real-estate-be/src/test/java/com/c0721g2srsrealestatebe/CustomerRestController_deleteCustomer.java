package com.c0721g2srsrealestatebe;

import com.c0721g2srsrealestatebe.controller.CustomerController;
import com.c0721g2srsrealestatebe.model.customer.Customer;
import com.c0721g2srsrealestatebe.repository.customer.ICustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Objects;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class CustomerRestController_deleteCustomer {

    @Autowired
    private CustomerController customerController;
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Autowired
    private MockMvc mockMvc;

    //        ResponseEntity<Customer> responseEntity
//                = this.customerController.deleteCustomer("KH-0001");
//        Assertions.assertEquals(true,responseEntity.getBody().getDeleted().booleanValue());
//        Mockito.when(iCustomerRepository.findById("KH-0002"));

//     ThienLB -  xoa khach hang
//    [id] tồn tại trong database
    @Test
    public void deleteCustomer_1() throws Exception {

        this.mockMvc.perform
                (MockMvcRequestBuilders
                        .delete("/api/customers/delete-customer/{id}", "KH-0002"))
                        .andDo(print())
                        .andExpect(status().is2xxSuccessful());

    }

//    [id] = rỗng ("")
    @Test
    public void deleteCustomer_2() throws Exception {

        this.mockMvc.perform
                (MockMvcRequestBuilders
                        .delete("/api/customers/delete-customer/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }
//    [id] = null
    @Test
    public void deleteCustomer_3() throws Exception {

        this.mockMvc.perform
                (MockMvcRequestBuilders
                        .delete("/api/customers/delete-customer/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

//     [id] không tồn tại trong DB
    @Test
    public void deleteCustomer_4() throws Exception {

        this.mockMvc.perform
                (MockMvcRequestBuilders
                        .delete("/api/customers/delete-customer/{id}", "KH-0011"))
                .andDo(print())
                .andExpect(status().isNotFound());

    }


}
