package com.incredible.springbean.lifecycle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class TestPersonBean {
    public static void main(String[] args) {
    
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
       PersonBean bean = (PersonBean)context.getBean("personBean");    
           System.out.println(bean.getName());
       ((AbstractApplicationContext) context).registerShutdownHook();
    }
}