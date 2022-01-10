package com.c0721g2srsrealestatebe.controller;

import com.c0721g2srsrealestatebe.dto.EmployeeDTO;
import com.c0721g2srsrealestatebe.model.employee.Degree;
import com.c0721g2srsrealestatebe.model.employee.Employee;
import com.c0721g2srsrealestatebe.model.employee.Position;
import com.c0721g2srsrealestatebe.service.employee.IDegreeService;
import com.c0721g2srsrealestatebe.service.employee.IEmployeeService;
import com.c0721g2srsrealestatebe.service.employee.IPositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeController {
    @Autowired
    IEmployeeService iEmployeeService;
    @Autowired
    IDegreeService iDegreeService;
    @Autowired
    IPositionService iPositionService;

    @GetMapping(value = "/position")
    public ResponseEntity<List<Position>> getPosition() {
        List<Position> positions = iPositionService.findAllPosition();
        if (positions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(positions, HttpStatus.OK);
    }


    @GetMapping(value = "/degree")
    public ResponseEntity<List<Degree>> getDegree() {
        List<Degree> degrees = iDegreeService.findAllDegree();
        if (degrees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(degrees, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getList(){
        List<Employee> employeeList = iEmployeeService.findAll();
        if (employeeList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Employee> findByIdEmployee(@PathVariable String id) {
        Optional<Employee> employeeOptional = iEmployeeService.findById(id);
        if (!employeeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employeeOptional.get(), HttpStatus.OK);
    }


    @PostMapping(value = "/create")
    public ResponseEntity<Object> createEmployee(@RequestBody @Valid EmployeeDTO employeeDTO,
                                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.BAD_REQUEST);
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
        this.iEmployeeService.saveEmployee(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
