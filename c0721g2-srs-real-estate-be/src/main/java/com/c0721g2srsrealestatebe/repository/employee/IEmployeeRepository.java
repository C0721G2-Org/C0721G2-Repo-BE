package com.c0721g2srsrealestatebe.repository.employee;

import com.c0721g2srsrealestatebe.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, String>, JpaSpecificationExecutor<Employee> {
    @Query(value= "select * from employees " , nativeQuery= true)
    Page<Employee> findAllEmployee(Pageable pageable );

    @Query(value= " delete from employees where id = :id" , nativeQuery= true)
    void deleteEmployeeByID(@Param("id") String id );

    @Query(value= "select *  from employees where  name like concat('%',:name,'%' ) and  email like concat('%',:email,'%' )" +
            " and degree_id = :degree_id" , nativeQuery= true)
    Page<Employee> searchEmployeeByNameOrEmailOrDegree(Pageable pageable, @Param("name") String name, @Param("email")
            String email, @Param("degree_id") int degree_id );
}
