package com.c0721g2srsrealestatebe.service.employee.impl;

import com.c0721g2srsrealestatebe.model.employee.Employee;
import com.c0721g2srsrealestatebe.repository.employee.IEmployeeRepository;
import com.c0721g2srsrealestatebe.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    IEmployeeRepository iEmployeeRepository;

    @Override
    public Page<Employee> findAllEmployeePage(Pageable pageable) {
        return this.iEmployeeRepository.findAllEmployee(pageable);
    }

    @Override
    public void deleteById(String id) {
        this.iEmployeeRepository.deleteEmployeeByID(id);
    }

    @Override
    public Optional<Employee> findByIdOp(String id) {
        return this.iEmployeeRepository.findById(id);
    }
}
