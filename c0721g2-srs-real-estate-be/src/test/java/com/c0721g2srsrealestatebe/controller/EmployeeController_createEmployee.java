package com.c0721g2srsrealestatebe.controller;

import com.c0721g2srsrealestatebe.dto.EmployeeDTO;
import com.c0721g2srsrealestatebe.dto.PositionDTO;
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
public class EmployeeController_createEmployee {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createEmployee_18() throws Exception {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setName("Nguyễn Văn An");
        employeeDTO.setGrade(8.0);
        employeeDTO.setDateOfBirth("2000/10/05");
        employeeDTO.setGender(1);

        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setId(1L);
        employeeDTO.setPositionDTO(positionDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("api/employee/create")
                        .content(this.objectMapper.writeValueAsString(employeeDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
