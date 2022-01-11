package com.c0721g2srsrealestatebe.repository.employee;

import com.c0721g2srsrealestatebe.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, String>, JpaSpecificationExecutor<Employee> {
    @Query(value= "select * from employees " , nativeQuery= true)
    Page<Employee> findAllEmployee(Pageable pageable );

    @Query(value= "delete from empployees where ecommerce where employee.id = :id" , nativeQuery= true)
    void deleteEmployeeByID(@Param("id") String id );
}
