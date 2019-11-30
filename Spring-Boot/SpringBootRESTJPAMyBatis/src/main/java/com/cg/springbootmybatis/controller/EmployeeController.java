package com.cg.springbootmybatis.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.springbootmybatis.exception.ResourceNotFoundException;
import com.cg.springbootmybatis.mapper.EmployeeMapper;
import com.cg.springbootmybatis.model.Employee;

@RestController
@RequestMapping("/api/employee/")
public class EmployeeController {

	@Autowired
	EmployeeMapper employeeMapper;

	// Get All Employees
	@GetMapping("/all")
	public List<Employee> getAllNotes() {
		return employeeMapper.getAllEmployees();
	}

	// Create a new Employee
	@PostMapping("/create")
	public Integer createNote(@Valid @RequestBody Employee employee) throws Exception {
		return employeeMapper.insertEmployee(employee);
	}

	// Delete a Employee
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable(value = "id") Integer id) {
		Employee employee = employeeMapper.findById(id);
		if (employee != null)
			employeeMapper.deleteById(id);
		else
			throw new ResourceNotFoundException("Employee", "id", id);
		return ResponseEntity.ok().build();
	}

	// Get a Single Employee
	@GetMapping("/get/{id}")
	public Employee getNoteById(@PathVariable(value = "id") Integer id) {
		Employee employee = employeeMapper.findById(id);
		if (employee != null)
			return employee;
		else
			throw new ResourceNotFoundException("Employee", "id", id);
	}

	// Update a Employee
	@PutMapping("/update/{id}")
	public Integer updateEmployee(@PathVariable(value = "id") Integer id, @Valid @RequestBody Employee employeeDetails)
			throws Exception {
		Integer updatedEmployee = 0;

		Employee employee = employeeMapper.findById(id);
		if (employee != null) {
			System.out.println("Employee Details to update:");
			System.out.println(
					employeeDetails.getId() + "\t" + employeeDetails.getName() + "\t" + employeeDetails.getSalary());
			employee.setId(id);
			employee.setName(employeeDetails.getName());
			employee.setSalary(employeeDetails.getSalary());
			updatedEmployee = employeeMapper.updateEmployee(employee);
		} else
			throw new ResourceNotFoundException("Employee", "id", id);

		return updatedEmployee;
	}
}