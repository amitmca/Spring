package com.technicalkeeda.repository;
import java.util.List;
import com.technicalkeeda.bean.Employee;

public interface EmployeeRepositoryCustom {
 
    List<Employee> getFirstNamesLike1(String firstName);
 
}