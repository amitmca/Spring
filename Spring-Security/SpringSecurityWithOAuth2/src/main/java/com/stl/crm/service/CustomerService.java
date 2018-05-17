package com.stl.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.stl.crm.domain.Customer;
import com.stl.crm.repository.CustomerRepository;

@Service
@Transactional
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Iterable<Customer> getCustomers() {
		return customerRepository.findAll();
	}

	public Customer getCustomer(long customerId) {
		return customerRepository.findOne(customerId);
	}
	
	public Customer updateCustomer(long customerId, Customer customer) {
		return customerRepository.save(customer);
		
	}

	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}	
 
	public void deleteCustomer(Customer customer) {
		customerRepository.delete(customer);
	}

}
