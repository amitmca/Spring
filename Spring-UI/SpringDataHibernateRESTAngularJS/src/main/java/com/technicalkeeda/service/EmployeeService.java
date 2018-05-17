package com.technicalkeeda.service;

import java.util.List;

import com.technicalkeeda.bean.Employee;

public interface EmployeeService {
	public List<Employee> getEmployees();

	public Employee getEmployee(int employeeId);

	public Employee deleteEmployee(int employeeId);

	public Employee updateEmployee(Employee employee);

	public Employee createEmployee(Employee employee);
	
	List<Employee> getFirstNamesLike(String firstName);
	
	List<Employee> getFirstNamesLike1(String firstName);
}