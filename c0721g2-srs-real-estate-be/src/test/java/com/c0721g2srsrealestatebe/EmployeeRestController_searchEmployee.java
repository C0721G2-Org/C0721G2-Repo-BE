package com.c0721g2srsrealestatebe;

import com.c0721g2srsrealestatebe.controller.EmployeeController;
import com.c0721g2srsrealestatebe.model.employee.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

public class EmployeeRestController_searchEmployee {

    @Autowired
    EmployeeController employeeController;

    @Autowired
    private MockMvc mockMvc;

//    @Test
//    public void searchEmployeeByName() {
//        ResponseEntity<Page<Employee>> responseEntity
//                 = this.employeeController.searchEmployee(PageRequest.of(0, 10),"Mai","","");
//        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
//        Assertions.assertEquals("Mai Thị Bích Phương", responseEntity.getBody().getContent().get(0).getName());
//    }
}
