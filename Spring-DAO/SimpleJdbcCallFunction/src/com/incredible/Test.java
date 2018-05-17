package com.incredible;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		EmployeeJDBCTemplate empJDBCTemplate = (EmployeeJDBCTemplate) context.getBean("employeeJDBCTemplate");
		Employee emp=empJDBCTemplate.getEmployeeDetails(1);
		
		System.out.println("Name:"+emp.getName());
	    //System.out.println("Salary:"+emp.getSalary());
	}
}
