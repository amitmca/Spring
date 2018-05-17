package com.technicalkeeda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.technicalkeeda.bean.Employee;
 
public interface EmployeeRepository extends JpaRepository<Employee, Integer>,EmployeeRepositoryCustom{
	@Query(value ="select e from Employee as e where e.first_name like lower(concat('%', ?1,'%')) ")
	List<Employee> getFirstNamesLike(String firstName);
}