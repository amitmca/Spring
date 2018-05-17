package com.srcsys.test;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.srcsys.service.Playground;

public class PlayGroundTest {
	public static void main(String[] args) {

		XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(
				"springtutorial-context.xml"));

		Playground playground = (Playground) beanFactory.getBean("playground");
		playground.play();
	}

}