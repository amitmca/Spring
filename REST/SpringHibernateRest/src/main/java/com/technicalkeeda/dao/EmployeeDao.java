package com.technicalkeeda.dao;

import java.util.List;
import com.technicalkeeda.bean.Employee;

public interface EmployeeDao {
	public List<Employee> getEmployees();

	public Employee getEmployee(Long employeeId);

	public void deleteEmployee(Long employeeId);

	public void updateEmployee(Employee employee);

	public void createEmployee(Employee employee);
}