package com.technicalkeeda.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.technicalkeeda.bean.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Employee> getEmployees() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("From Employee");
		List list = query.list();
		tx.commit();
		session.close();
		return list;
	}

	@Override
	public Employee getEmployee(Long employeeId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Employee emp = (Employee) session.get(Employee.class, employeeId);
		tx.commit();
		session.close();
		return emp;
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Employee emp = getEmployee(employeeId);
		session.delete(emp);
		tx.commit();
		session.close();
	}

	@Override
	public void updateEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(employee);
		tx.commit();
		session.close();
	}

	@Override
	public void createEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(employee);
		tx.commit();
		session.close();
	}
}