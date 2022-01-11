package com.c0721g2srsrealestatebe;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = EmployeeRestController_deleteEmployee.class)
@AutoConfigureMockMvc
public class EmployeeRestController_deleteEmployee {
    @Autowired
    private MockMvc mockMvc;


    @Test
    public void deleteEmployeeById() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .delete("/employee/delete/{id}", "NV-0002"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.name").value("Mai Thị Bích Phương"));
//                .andExpect(jsonPath("$.dateOfBirth").value("1988-10-30"));
    }

    @Test
    public void deleteEmployeeEmpty() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/employee/delete/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
