package com.technicalkeeda.service;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.technicalkeeda.bean.Employee;
import com.technicalkeeda.repository.EmployeeRepository;
import com.technicalkeeda.repository.EmployeeRepositoryCustom;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Resource
	private EmployeeRepository employeeRepository;

	@PersistenceContext
	EntityManager entityManager;

	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	public Employee getEmployee(int employeeId) {
		return employeeRepository.findOne(employeeId);
	}

	public Employee deleteEmployee(int employeeId) {
		Employee deletedEmployee = employeeRepository.findOne(employeeId);
		employeeRepository.delete(deletedEmployee);
		return deletedEmployee;
	}

	@Override
    @Transactional
	public Employee updateEmployee(Employee employee) {
		Employee updatedEmployee = employeeRepository.findOne(employee
				.getEmployeeId());
		updatedEmployee.setEmployeeId(employee.getEmployeeId());
		updatedEmployee.setFirstName(employee.getFirstName());
		updatedEmployee.setLastName(employee.getLastName());
		updatedEmployee.setAge(employee.getAge());
		
		System.out.println("Updated Employee Details:");
		System.out.println(updatedEmployee.getFirstName() + "\t"
				+ updatedEmployee.getLastName() + "\t"
				+ updatedEmployee.getAge());
		return updatedEmployee;
	}

	public Employee createEmployee(Employee employee) {
		Employee createdEmployee = employee;
		System.out.println("Created Employee Details:");
		System.out.println(createdEmployee.getFirstName() + "\t"
				+ createdEmployee.getLastName() + "\t"
				+ createdEmployee.getAge());
		return employeeRepository.save(createdEmployee);
	}

	public List<Employee> getFirstNamesLike(String firstName){
		return employeeRepository.getFirstNamesLike(firstName);
	}
	
	public List<Employee> getFirstNamesLike1(String firstName){
		return employeeRepository.getFirstNamesLike1(firstName);
	}
	
}