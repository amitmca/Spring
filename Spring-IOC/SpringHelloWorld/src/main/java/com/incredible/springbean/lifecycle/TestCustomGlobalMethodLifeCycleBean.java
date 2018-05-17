package com.incredible.springbean.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
public class TestCustomGlobalMethodLifeCycleBean {
    public static void main(String[] args) {
     
           ApplicationContext context = 
                new ClassPathXmlApplicationContext("applicationContext.xml"); 
           CustomGlobalLifeCycleMehodBean bean = (CustomGlobalLifeCycleMehodBean)context.getBean("customGlobalLifeCycleMethodBean");
           ((AbstractApplicationContext) context).registerShutdownHook();
     }
}