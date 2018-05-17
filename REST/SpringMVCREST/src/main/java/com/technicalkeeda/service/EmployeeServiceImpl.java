package com.technicalkeeda.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.technicalkeeda.bean.Employee;
import com.technicalkeeda.dao.EmployeeDao;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;

	public List<Employee> getEmployees() {
		List<Employee> employees = employeeDao.getEmployees();
		return employees;
	}

	public Employee getEmployee(Long employeeId) {
		Employee employee = employeeDao.getEmployee(employeeId);
		return employee;
	}

	public void deleteEmployee(Long employeeId) {
		employeeDao.deleteEmployee(employeeId);
	}

	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
	}

	public void createEmployee(Employee employee) {
		employeeDao.createEmployee(employee);
	}
}