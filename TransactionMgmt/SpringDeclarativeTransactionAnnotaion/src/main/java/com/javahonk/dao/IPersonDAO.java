package com.javahonk.dao;

import com.javahonk.di.bean.Person;

public interface IPersonDAO {
    void insertUser(Person person) throws MyException;
    void deletePerson(int personID);
    void selectAllPerson();
    void selectPersonByName();
    
}