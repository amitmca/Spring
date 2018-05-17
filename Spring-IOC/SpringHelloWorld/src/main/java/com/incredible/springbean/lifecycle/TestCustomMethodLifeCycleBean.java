package com.incredible.springbean.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
public class TestCustomMethodLifeCycleBean {
     public static void main(String[] args) {
 
        ApplicationContext context = 
            new ClassPathXmlApplicationContext("applicationContext.xml");
 
        CustomLifeCycleMethodBean bean = (CustomLifeCycleMethodBean)context.getBean("customLifeCycleMethodBean");
           ((AbstractApplicationContext) context).registerShutdownHook();
      }
}