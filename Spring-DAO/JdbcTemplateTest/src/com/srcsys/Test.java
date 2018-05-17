package com.srcsys;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

		EmployeeDao dao = (EmployeeDao) ctx.getBean("edao");
		
		int status = dao.saveEmployee(new Employee(3, "Amay Bhalerao",25000));

		int status1 = dao.updateEmployee(new Employee(3, "Amey Bhalerao",55000));
		
		int status2 =dao.deleteEmployee(3);
		
		dao.saveEmployeeByPreparedStatement(new Employee(3, "Amay Bhalerao",35000));
		
		dao.updateEmployeeByPreparedStatement(new Employee(3, "Amey Bhalerao",35000));
	
		dao.deleteEmployeeByPreparedStatement(3);

		
		System.out.println("Displaying Rows by ResultSetExtractor::::");
		List<Employee> list = dao.getAllEmployees();

		for (Employee e : list)
			System.out.println(e);

		System.out.println("Displaying Rows by RowMapper:::::");
		List<Employee> list1 = dao.getAllEmployeesRowMapper();

		for (Employee e1 : list1)
			System.out.println(e1);
			
	}
}
