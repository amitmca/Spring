package com.programsji.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.programsji.bo.Person;

public interface Persondao {
	public Person getPerson(int id);

	public List<Person> listPersons();

	public void deletePerson(int id);

	public void addPerson(Person person);

	public void updatePerson(Person person);

}
