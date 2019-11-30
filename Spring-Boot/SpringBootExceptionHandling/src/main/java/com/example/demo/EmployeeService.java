package com.example.demo;

import java.util.Optional;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	@Autowired
	@Resource
	EmployeeRepository employeeRepository;
	
	public Optional<Employee> getEmployeeById(int id) {
		return employeeRepository.findById(id);
	}
	
	public void addEmployee(Employee employee){  
		employeeRepository.save(employee);  
    }  

}
