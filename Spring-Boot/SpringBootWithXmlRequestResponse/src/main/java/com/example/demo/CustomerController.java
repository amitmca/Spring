package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @GetMapping(path = "/get-cust-info")
    public Customer customerInformation() {
        Customer cust = new Customer();
        cust.setCustNo(100);
        cust.setName("Bank of America");
        cust.setCountry("United States");
        return cust;
    }
    
    @PostMapping(path = "/save-cust-info")
    public String customerInformation(@RequestBody Customer cust) {
         return "Customer information saved successfully ::." + cust.getCustNo() + " " + cust.getName() + " " + cust.getCountry();
    }
}