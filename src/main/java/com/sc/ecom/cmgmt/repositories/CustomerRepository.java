package com.sc.ecom.cmgmt.repositories;

import com.sc.ecom.cmgmt.dao.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findAllByAddress(String addr);
    List<Customer> findByName(String name);
}
