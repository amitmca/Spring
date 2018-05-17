package com.programsji.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.programsji.bo.Person;
import com.programsji.dao.Persondao;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

	@Autowired
	Persondao personDao;

	@Override
	public Person getPerson(int id) {
		return personDao.getPerson(id);
	}

	@Override
	public void updatePerson(Person person) {
		personDao.updatePerson(person);
	}

	@Override
	public List<Person> listPerson() {
		return personDao.listPersons();
	}

	@Override
	public void deletePerson(int id) {
		personDao.deletePerson(id);

	}

	@Override
	public void addPerson(Person person) {
		personDao.addPerson(person);

	}

}
