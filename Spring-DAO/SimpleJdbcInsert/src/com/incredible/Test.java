package com.incredible;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		EmployeeJDBCTemplate empJDBCTemplate = (EmployeeJDBCTemplate) context.getBean("employeeJDBCTemplate");
		empJDBCTemplate.saveEmployee(11, "TestEmp", 25000);
	}
}
