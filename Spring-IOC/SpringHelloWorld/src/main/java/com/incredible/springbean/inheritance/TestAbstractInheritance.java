package com.incredible.springbean.inheritance;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class TestAbstractInheritance {
    public static void main(String[] args) {
       ApplicationContext context = 
       new ClassPathXmlApplicationContext("applicationContext.xml");
       ParentBean childrenBean = (ParentBean)context.getBean("childBean");
       System.out.println("=====Child Bean====");
       System.out.println("Message ::" + childrenBean.getMessage());
       System.out.println("Title ::" + childrenBean.getTitle());
       ((AbstractApplicationContext) context).registerShutdownHook();
    }
}