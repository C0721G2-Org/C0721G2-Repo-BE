package com.c0721g2srsrealestatebe.repository.customer;

import com.c0721g2srsrealestatebe.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ICustomerRepository extends JpaRepository<Customer,String> {
}
