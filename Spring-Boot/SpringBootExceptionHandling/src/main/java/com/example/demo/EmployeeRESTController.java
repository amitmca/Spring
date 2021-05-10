package com.example.demo;

import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeRESTController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping(value = "/employees")
	public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee) {
		employeeService.addEmployee(employee);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@GetMapping(value = "/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id) {
		Optional<Employee> employee = employeeService.getEmployeeById(id);

		if (employee == null) {
			throw new RecordNotFoundException("Invalid employee id : " + id);
		}
		return new ResponseEntity<Employee>(HttpStatus.OK);
	}
}
