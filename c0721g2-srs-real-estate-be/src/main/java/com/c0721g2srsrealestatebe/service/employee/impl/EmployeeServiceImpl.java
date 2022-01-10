package com.c0721g2srsrealestatebe.service.employee.impl;

import com.c0721g2srsrealestatebe.model.employee.Degree;
import com.c0721g2srsrealestatebe.model.employee.Employee;
import com.c0721g2srsrealestatebe.repository.employee.IEmployeeRepository;
import com.c0721g2srsrealestatebe.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    IEmployeeRepository iEmployeeRepository;

    @Override
    public void saveEmployee(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> findById(String id) {
        return iEmployeeRepository.findById(id);
    }

    @Override
    public List<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }

}
