package com.technicalkeeda.service;

import java.util.List;
import com.technicalkeeda.bean.Employee;

public interface EmployeeService {
	public List<Employee> getEmployees();

	public Employee getEmployee(Long employeeId);

	public void deleteEmployee(Long employeeId);

	public void updateEmployee(Employee employee);

	public void createEmployee(Employee employee);
}