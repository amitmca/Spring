package com.programsji.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.programsji.bo.Person;

@Repository
public class PersondaoImpl implements Persondao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Person getPerson(int id) {
		Person person = (Person) getCurrentSession().get(Person.class, id);
		return person;
	}

	@Override
	public List<Person> listPersons() {
		return getCurrentSession().createQuery("From Person").list();
	}

	@Override
	public void deletePerson(int id) {
		Person person = getPerson(id);
		getCurrentSession().delete(person);
	}

	@Override
	public void addPerson(Person person) {
		getCurrentSession().save(person);

	}

	@Override
	public void updatePerson(Person person) {
		getCurrentSession().update(person);

	}
}
