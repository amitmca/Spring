package com.incredible.springbean.inheritance;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class TestTemplateInheritance {
    public static void main(String[] args) {
        ApplicationContext context = 
                new ClassPathXmlApplicationContext("applicationContext.xml");
        ParentBean parentBean = (ParentBean)context.getBean("childBean");
        System.out.println("=====Child Bean====");
        System.out.println("Message ::" + parentBean.getMessage());
        System.out.println("Title ::" + parentBean.getTitle());
        ((AbstractApplicationContext) context).registerShutdownHook();
    }
}