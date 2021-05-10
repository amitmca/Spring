package com.example.demo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    @Query(nativeQuery = true,value = "call getCustomerList")  // call store procedure 
    List<Customer> getCustomerList();
}