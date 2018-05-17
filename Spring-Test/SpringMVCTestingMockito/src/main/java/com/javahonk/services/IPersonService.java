package com.javahonk.services;

import java.util.List;
import java.util.Map;

import com.javahonk.domain.Person;

public interface IPersonService {
	
	int insertPerson(Person person);

	int updatePerson(Person person);

	void deletePerson(int personID);

	List<Map<String, Object>> selectAllPerson();
	
	
}
