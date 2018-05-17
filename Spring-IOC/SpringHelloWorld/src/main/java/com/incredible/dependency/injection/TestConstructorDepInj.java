package com.incredible.dependency.injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestConstructorDepInj {
	public static void main(String[] args) {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("dependency.xml");
		TextEditor te = (TextEditor) context.getBean("textEditor");
		te.spellCheck();
	}

}
