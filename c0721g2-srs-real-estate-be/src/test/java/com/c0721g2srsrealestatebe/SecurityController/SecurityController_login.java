package com.c0721g2srsrealestatebe.SecurityController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SecurityController_login {
    @Autowired
    private MockMvc mockMvc;

    //test chua dang nhap
    @Test
    public void shouldNotAllowAccessToUnauthenticatedUsers() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/test")).andExpect(status().is4xxClientError());
    }
    //test dăng nhap thanh cong
    @Test
    public void authenticateUser_7() throws Exception {
        String username = "admin";
        String password = "123";

        String body = "{\"username\":\"" + username + "\", \"password\":\"" + password + "\"}";
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/public/login")
                .content(body)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.username").value("admin"))
                .andExpect(jsonPath("$.roles").value("ROLE_ADMIN"));


    }
    //test sql injection
    @Test
    public void authenticateUser_1() throws Exception {
        String username = "'' OR '' = ''";
        String password = "123";

        String body = "{\"username\":\"" + username + "\", \"password\":\"" + password + "\"}";
        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/api/public/login")
                        .content(body))
                .andExpect(status().is4xxClientError());
    }

    //test sai username
    @Test
    public void authenticateUser_5() throws Exception {
        String username = "wrongusername";
        String password = "123";

        String body = "{\"username\":\"" + username + "\", \"password\":\"" + password + "\"}";
        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/api/public/login")
                        .content(body))
                .andExpect(status().is4xxClientError());
    }

    //test sai password
    @Test
    public void authenticateUser_6() throws Exception {
        String username = "admin";
        String password = "wrongpassword";

        String body = "{\"username\":\"" + username + "\", \"password\":\"" + password + "\"}";
        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/api/public/login")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().is4xxClientError())
        ;
    }


}
