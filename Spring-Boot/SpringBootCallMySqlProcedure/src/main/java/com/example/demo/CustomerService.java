package com.example.demo;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Customer;
import com.example.demo.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	@Resource
	private CustomerRepository customerRepository;

	public List<Customer> getCustomerList() {
		return customerRepository.getCustomerList();
	}
}
