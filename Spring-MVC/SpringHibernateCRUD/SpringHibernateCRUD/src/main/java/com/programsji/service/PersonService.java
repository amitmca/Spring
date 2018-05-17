package com.programsji.service;

import java.util.List;

import com.programsji.bo.Person;

public interface PersonService {
	public Person getPerson(int id);

	public void updatePerson(Person person);

	public List<Person> listPerson();

	public void deletePerson(int id);

	public void addPerson(Person person);

}
