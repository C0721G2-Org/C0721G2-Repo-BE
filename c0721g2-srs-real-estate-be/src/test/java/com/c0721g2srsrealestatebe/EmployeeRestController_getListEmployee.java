package com.c0721g2srsrealestatebe;

import com.c0721g2srsrealestatebe.controller.EmployeeController;
import com.c0721g2srsrealestatebe.model.employee.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;


@SpringBootTest(classes = EmployeeRestController_getListEmployee.class)
public class EmployeeRestController_getListEmployee {

   @Autowired
   EmployeeController employeeController;


    @Test
    public void getListEmployeeNull() {

        ResponseEntity<Page<Employee>> responseEntity
                = this.employeeController.showListEmployee(PageRequest.of(0, 10));

        Assertions.assertEquals(204, responseEntity.getStatusCodeValue());
    }




    @Test
    public void getListEmployeeSuccess() {
        ResponseEntity<Page<Employee>> responseEntity =
                this.employeeController.showListEmployee(PageRequest.of(0,10));
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(2,responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(11,responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("Nguyễn Văn Nam", responseEntity.getBody().getContent().get(2).getName());
//        Assertions.assertEquals("1989-12-30", responseEntity.getBody().getContent().get(2).getDateOfBirth());
    }
}
