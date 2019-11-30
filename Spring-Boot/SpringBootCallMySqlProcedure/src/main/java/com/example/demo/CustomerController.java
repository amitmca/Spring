package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @Autowired
    public CustomerService customerService;

    @RequestMapping("/getCustInfo")
    public List<Customer> customerInformation() {
       return customerService.getCustomerList(); 
    }
}