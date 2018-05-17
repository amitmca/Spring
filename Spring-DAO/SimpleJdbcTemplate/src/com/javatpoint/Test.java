package com.javatpoint;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Test {
	public static void main(String[] args) {

		Resource r = new ClassPathResource("applicationContext.xml");
		
		BeanFactory factory = new XmlBeanFactory(r);

		EmpDao dao = (EmpDao) factory.getBean("edao");
		
		int status = dao.saveEmployee(new Emp(5, "Avani Bhalerao", 35000));
		
		int status1 = dao.updateEmployee(new Emp(4, "Mrs.Kasturi Bhalerao", 35000));
		
		int status2 = dao.deleteEmployee(20);
	}
}
