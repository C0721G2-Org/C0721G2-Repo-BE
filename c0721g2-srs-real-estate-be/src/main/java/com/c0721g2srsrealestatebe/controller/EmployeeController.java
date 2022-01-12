package com.c0721g2srsrealestatebe.controller;

import com.c0721g2srsrealestatebe.dto.AppUserDTO;
import com.c0721g2srsrealestatebe.dto.EmployeeDTO;
import com.c0721g2srsrealestatebe.dto.PositionDTO;
import com.c0721g2srsrealestatebe.model.account.AppUser;
import com.c0721g2srsrealestatebe.model.account.Role;
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
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeController {
    @Autowired
    IEmployeeService iEmployeeService;
    @Autowired
    IDegreeService iDegreeService;
    @Autowired
    IPositionService iPositionService;

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

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
    public ResponseEntity<List<Employee>> getList() {
        List<Employee> employeeList = iEmployeeService.findAll();
        if (employeeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @GetMapping(value = "/edit/{id}")
    public ResponseEntity<Employee> findByIdEmployee(@PathVariable String id) {
        Optional<Employee> employeeOptional = iEmployeeService.findById(id);
        if (!employeeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employeeOptional.get(), HttpStatus.OK);
    }


    @PatchMapping(value = "/create")
    public ResponseEntity<?> createEmployee(@RequestBody @Valid EmployeeDTO employeeDTO,
                                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(),
                    HttpStatus.NOT_ACCEPTABLE);
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
//        System.out.println("dto"+ employeeDTO.toString());
//        System.out.println(employee);

        //set vị trí
        Position position = new Position();
        System.out.println(position.toString());
        position.setId(employeeDTO.getPositionDTO().getId());
        employee.setPosition(position);
        System.out.println(employee);

        //set bằng cấp
        Degree degree = new Degree();
        degree.setId(employeeDTO.getDegreeDTO().getId());
        employee.setDegree(degree);


        // Set role
        Role role = new Role();
        role.setId(employeeDTO.getRoleDTO());
        Set<Role> roles = new HashSet<>();
        roles.add(role);

        //tạo account
        AppUser appUser = new AppUser();
        appUser.setUsername(employeeDTO.getEmail());
//        appUser.setPassword(bCryptPasswordEncoder.encode("abc123456"));
        appUser.setPassword("abc123456");
        appUser.setRoles(roles);
        employee.setAppUser(appUser);
        System.out.println("Test employee: " + employee);
        System.out.println("Test app user: " + " " + appUser.toString());
        this.iEmployeeService.saveEmployee(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //tạo thuộc tính role tỏng dto
    @PatchMapping(value = "/edit")
    public ResponseEntity<Object> updateEmployee(@RequestBody @Valid EmployeeDTO employeeDTO,
                                                 BindingResult bindingResult) {
        System.out.println(employeeDTO);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.NOT_ACCEPTABLE);

        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
//        System.out.println("dto"+ employeeDTO.toString());
//        System.out.println(employee);

        //set vị trí
        Position position = new Position();
        System.out.println(position.toString());
        position.setId(employeeDTO.getPositionDTO().getId());
        employee.setPosition(position);
        System.out.println(employee);

        //set bằng cấp
        Degree degree = new Degree();
        degree.setId(employeeDTO.getDegreeDTO().getId());
        employee.setDegree(degree);

        // Set role
        Role role = new Role();
        role.setId(employeeDTO.getRoleDTO());
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        AppUser appUser = new AppUser();
        appUser.setRoles(roles);
        employee.setAppUser(appUser);

        this.iEmployeeService.saveEmployee(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
