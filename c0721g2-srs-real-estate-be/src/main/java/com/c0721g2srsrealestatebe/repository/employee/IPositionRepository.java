package com.c0721g2srsrealestatebe.repository.employee;

import com.c0721g2srsrealestatebe.model.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPositionRepository extends JpaRepository<Position, Long> {

}
