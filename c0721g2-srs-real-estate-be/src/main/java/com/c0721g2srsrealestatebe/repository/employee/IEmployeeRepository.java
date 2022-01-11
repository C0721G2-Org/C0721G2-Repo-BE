package com.c0721g2srsrealestatebe.repository.employee;

import com.c0721g2srsrealestatebe.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, String> {
    @Modifying
    @Transactional
    @Query(value = "insert into employees (id, address, date_of_birth, email, gender,id_card, `name`, phone_number, app_user_id, degree_id, image_id,position_id) " +
            " VALUES (:id, :address, :date_of_birth,:deleted, :email, :gender,:id_card, :name, :phone_number, :app_user_id, :degree_id, :image_id,:position_id)", nativeQuery = true)
    Employee saveEmployee(@Param("id") String id, @Param("address") String address,
                          @Param("date_of_birth") String date_of_birth,@Param("email") String email,
                          @Param("gender") int gender, @Param("id_card") String id_card,
                          @Param("name") String name,
                          @Param("phone_number") String phone_number, @Param("app_user_id") String app_user_id,
                          @Param("degree_id") Long degree_id, @Param("image_id") Long image_id,
                          @Param("position_id") Long position_id);


}
