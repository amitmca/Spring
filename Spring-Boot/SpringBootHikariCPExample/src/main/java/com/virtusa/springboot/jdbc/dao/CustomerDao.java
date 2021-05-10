package com.virtusa.springboot.jdbc.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.virtusa.springboot.jdbc.model.Customer;

@Repository
public class CustomerDao {

     @Autowired
     private JdbcTemplate jdbcTemplate;

     private static final String SQL = "select * from customer";

     public List<Customer> getAllCustomers() {

          List<Customer> customers = new ArrayList<Customer>();
          List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL);

          for (Map<String, Object> row : rows) 
          {
               Customer customer = new Customer();
               customer.setId((int)row.get("id"));
               customer.setCustName((String)row.get("name"));
               customer.setAddress((String)row.get("address"));
               customer.setPhone((String)row.get("phone"));
               customer.setContactPerson((String)row.get("contact"));
               customers.add(customer);
           }

         return customers;
     }
}