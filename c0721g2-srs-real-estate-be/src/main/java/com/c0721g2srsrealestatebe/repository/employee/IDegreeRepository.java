package com.c0721g2srsrealestatebe.repository.employee;

import com.c0721g2srsrealestatebe.model.employee.Degree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDegreeRepository extends JpaRepository<Degree, Long> {
}
