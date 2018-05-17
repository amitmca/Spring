package com.technicalkeeda.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.technicalkeeda.bean.Employee;

public class EmployeeRepositoryImpl implements EmployeeRepositoryCustom{
	@PersistenceContext
	private EntityManager entityManager;  

	@Override
	public List<Employee> getFirstNamesLike1(String firstName) {
		Query query = entityManager.createNativeQuery("select e from Employee e where e.employeeName like '%"+firstName+"%' ",
				Employee.class);
		query.setParameter(1, firstName);

		return query.getResultList();
	}

}