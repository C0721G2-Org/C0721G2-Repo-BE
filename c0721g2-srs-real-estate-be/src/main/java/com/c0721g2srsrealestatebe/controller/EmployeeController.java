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
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/employee")

public class EmployeeController {

    @Qualifier("employeeServiceImpl")
    @Autowired
    IEmployeeService iEmployeeService;

    @Qualifier("degreeServiceImpl")
    @Autowired
    IDegreeService iDegreeService;

    @Qualifier("positionServiceImpl")
    @Autowired
    IPositionService iPositionService;

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping(value = "/position")
    public ResponseEntity<List<Position>> getPosition() {
        List<Position> positions = iPositionService.findAll();
        if (positions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(positions, HttpStatus.OK);
    }


    @GetMapping(value = "/degree")
    public ResponseEntity<List<Degree>> getDegree() {
        List<Degree> degrees = iDegreeService.findAll();
        if (degrees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(degrees, HttpStatus.OK);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<Page<Employee>> showListEmployee(@PageableDefault(value = 10) Pageable pageable) {
        Page<Employee> employeeList = iEmployeeService.findAllEmployeePage(pageable);
        if (employeeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<Page<Employee>> searchEmployee(@PageableDefault(value = 10) Pageable pageable,
                                                         @RequestParam(defaultValue = "") String name,
                                                         @RequestParam(defaultValue = "") String email,
                                                         @RequestParam(defaultValue = "") String position_id
    ) {
        Page<Employee> employeeListSearch = iEmployeeService.findAllEmployeeSearch(pageable, name, email, position_id);
        if (employeeListSearch.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeeListSearch, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Employee> delete(@PathVariable String id) {
        Optional<Employee> employeeOptional = this.iEmployeeService.findByIdOp(id);
        if (!employeeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iEmployeeService.deleteById(id);
        return new ResponseEntity<>(employeeOptional.get(), HttpStatus.OK);
    }


    @GetMapping(value = "/detail/{id}")
    public ResponseEntity<Employee> findByIdEmployee(@PathVariable String id) {
        Optional<Employee> employeeOptional = iEmployeeService.findById(id);
        if (!employeeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employeeOptional.get(), HttpStatus.OK);
    }


    @PostMapping(value = "/create")
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
