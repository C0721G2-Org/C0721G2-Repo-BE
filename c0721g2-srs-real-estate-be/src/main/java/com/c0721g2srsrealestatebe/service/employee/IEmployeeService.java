package com.c0721g2srsrealestatebe.service.employee;

import com.c0721g2srsrealestatebe.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public interface IEmployeeService {

    public Page<Employee> findAllEmployeePage(Pageable pageable);
    void deleteById(String id);
    Optional<Employee> findByIdOp(String id);
}
