package com.technicalkeeda.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.technicalkeeda.bean.Employee;
import com.technicalkeeda.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	public EmployeeService employeeService;

	@RequestMapping(value = "/employee", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Employee>> employees() {
		HttpHeaders headers = new HttpHeaders();
		List<Employee> employees = employeeService.getEmployees();
		if (employees == null) {
			return new ResponseEntity<List<Employee>>(HttpStatus.NOT_FOUND);
		}
		headers.add("Number Of Records Found", String.valueOf(employees.size()));
		return new ResponseEntity<List<Employee>>(employees, headers,
				HttpStatus.OK);
	}

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
	public ResponseEntity<Employee> getEmployee(
			@PathVariable("id") int employeeId) {
		Employee employee = employeeService.getEmployee(employeeId);
		if (employee == null) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@RequestMapping(value = "/employee/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Employee> deleteEmployee(
			@PathVariable("id") int employeeId) {
		HttpHeaders headers = new HttpHeaders();
		Employee employee = employeeService.getEmployee(employeeId);
		if (employee == null) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		employeeService.deleteEmployee(employeeId);
		headers.add("Employee Deleted - ", String.valueOf(employeeId));
		return new ResponseEntity<Employee>(employee, headers,
				HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/employee", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Employee> createEmployee(
			@RequestBody Employee employee) {
		HttpHeaders headers = new HttpHeaders();
		if (employee == null) {
			return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
		}
		employeeService.createEmployee(employee);
		headers.add("Employee Created - ",
				String.valueOf(employee.getEmployeeId()));
		return new ResponseEntity<Employee>(employee, headers,
				HttpStatus.CREATED);
	}

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT,produces = "application/json")
	public ResponseEntity<Employee> updateEmployee(
			@PathVariable("id") int employeeId, @RequestBody Employee employee) {
		HttpHeaders headers = new HttpHeaders();
		Employee isExist = employeeService.getEmployee(employeeId);
		if (isExist == null) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		} else if (employee == null) {
			return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
		}
		employeeService.updateEmployee(employee);
		headers.add("Employee Updated - ", String.valueOf(employeeId));
		return new ResponseEntity<Employee>(employee, headers, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/employee/filter/{first_name}", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getFirstNamesLike(
			@PathVariable("first_name") String firstName) {
		List<Employee> employee = employeeService.getFirstNamesLike(firstName);
		if (employee == null) {
			return new ResponseEntity<List<Employee>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Employee>>(employee, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/employee/find/{first_name}", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getFirstNamesLike1(
			@PathVariable("first_name") String firstName) {
		List<Employee> employee = employeeService.getFirstNamesLike(firstName);
		if (employee == null) {
			return new ResponseEntity<List<Employee>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Employee>>(employee, HttpStatus.OK);
	}
}