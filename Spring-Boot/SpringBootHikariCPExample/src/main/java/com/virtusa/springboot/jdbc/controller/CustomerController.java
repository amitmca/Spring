package com.virtusa.springboot.jdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.virtusa.springboot.jdbc.dao.CustomerDao;
import com.virtusa.springboot.jdbc.model.Customer;

@RestController
public class CustomerController {

    @Autowired
    public CustomerDao dao;

    @RequestMapping("/getCustInfo")
    public List<Customer> customerInformation() {
        List<Customer> customers = dao.getAllCustomers(); 
        return customers;
    }
}