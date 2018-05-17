package com.incredible.springbean.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAwareBean {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AwareBean bean = (AwareBean) context.getBean("awareBean");
		((AbstractApplicationContext) context).registerShutdownHook();
	}
}