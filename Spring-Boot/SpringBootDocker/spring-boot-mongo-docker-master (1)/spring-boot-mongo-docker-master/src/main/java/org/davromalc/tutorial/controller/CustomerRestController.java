package org.davromalc.tutorial.controller;

import java.util.List;

import org.davromalc.tutorial.model.Customer;
import org.davromalc.tutorial.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CustomerRestController {
	
	public static final Logger log = LoggerFactory.getLogger(CustomerRestController.class);
	
	@Autowired
	private CustomerRepository repository;
	
	@GetMapping("/customers")
	public List<Customer> findAll(){
		final List<Customer> customers = repository.findAll();
		log.info("Fetching customers from database {}" , customers);
		return customers;
	}
	
	@PostMapping("customer")
	public void save(@RequestBody Customer customer){
		log.info("Storing customer in database {}", customer);
		repository.save(customer);
	}
	
}
