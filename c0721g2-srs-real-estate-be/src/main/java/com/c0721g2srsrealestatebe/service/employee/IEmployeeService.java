package com.c0721g2srsrealestatebe.service.employee;

import com.c0721g2srsrealestatebe.model.employee.Degree;
import com.c0721g2srsrealestatebe.model.employee.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    void saveEmployee(Employee employee);

    Optional<Employee> findById(String id);

    List<Employee> findAll();
}
