package com.c0721g2srsrealestatebe.controller;

import com.c0721g2srsrealestatebe.model.employee.Employee;
import com.c0721g2srsrealestatebe.service.employee.IDegreeService;
import com.c0721g2srsrealestatebe.service.employee.IEmployeeService;
import com.c0721g2srsrealestatebe.service.employee.IPositionService;
import com.c0721g2srsrealestatebe.service.employee.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "employee")
public class EmployeeController {

    @Qualifier("employeeServiceImpl")
    @Autowired
    IEmployeeService employeeService ;

    @Qualifier("degreeServiceImpl")
    @Autowired
    IDegreeService degreeService;

    @Qualifier("positionServiceImpl")
    @Autowired
    IPositionService positionService;

    @GetMapping(value = "/list")
    public ResponseEntity<Page<Employee>> showListEmployee(@PageableDefault(value= 5) Pageable pageable) {
        Page<Employee> employeeList = employeeService.findAllEmployeePage(pageable);
        if (employeeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<Page<Employee>> searchEmployee(@PageableDefault(value= 10) Pageable pageable,
                                                         @RequestParam(defaultValue = "") String name,
                                                         @RequestParam(defaultValue = "") String email,
                                                         @RequestParam(defaultValue = "")  int degree_id
                                                         ) {
        Page<Employee> employeeListSearch = employeeService.findAllEmployeeSearch(pageable, name, email, degree_id);
        if (employeeListSearch.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeeListSearch, HttpStatus.OK);
    }



    @DeleteMapping("delete/{id}")
    public ResponseEntity<Employee> delete(@PathVariable String id) {
        Optional<Employee> employeeOptional = this.employeeService.findByIdOp(id);
        if (!employeeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        employeeService.deleteById(id);
        return new ResponseEntity<>(employeeOptional.get(), HttpStatus.OK);
    }
}
