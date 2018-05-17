package com.incredible.dependency.injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCollectionInj {
	public static void main(String[] args) {
		ApplicationContext context =
		new ClassPathXmlApplicationContext("collection.xml");
		JavaCollection jc=(JavaCollection)context.getBean("javaCollection");
		jc.getAddressList();
		jc.getAddressSet();
		jc.getAddressMap();
		jc.getAddressProp();
		}
}
