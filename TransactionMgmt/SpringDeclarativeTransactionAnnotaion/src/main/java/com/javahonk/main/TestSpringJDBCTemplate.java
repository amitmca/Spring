package com.javahonk.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.javahonk.dao.IPersonDAO;
import com.javahonk.dao.MyException;
import com.javahonk.di.bean.Person;

public class TestSpringJDBCTemplate {

    public static void main(String[] args) throws MyException {
    
    ClassPathXmlApplicationContext applicationContext = 
        new ClassPathXmlApplicationContext(
            "spring.xml");

    IPersonDAO personDAO = applicationContext.
        getBean("personDAO", IPersonDAO.class);
    Person person = new Person("Swati", "Bhalerao", 
        "John st.","NY", "NY", "USA");
    
    //Insert user to the table 3 times:
   // for (int i = 0; i < 3; i++) {
        personDAO.insertUser(person); 
    //}
    
    //Delete first person from table
 //   personDAO.deletePerson(1);
        
    //Select all inserted user from the table
    personDAO.selectAllPerson();    
    
    
    //Below method we are throwing exception intentionally 
    //to check if transaction enabled 
    personDAO.selectPersonByName();
    

    applicationContext.close();

    }

}
