package com.javadeveloperzone.service;

import com.javadeveloperzone.model.Employee;
import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee save(Employee employee);
    void delete(String employeeId);
    Employee update(Employee employee);
}
