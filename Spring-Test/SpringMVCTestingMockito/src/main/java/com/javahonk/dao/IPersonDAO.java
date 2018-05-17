package com.javahonk.dao;

import java.util.List;
import java.util.Map;

import com.javahonk.domain.Person;

public interface IPersonDAO {
	
	int insertPerson(Person person);

	int updatePerson(Person person);

	void deletePerson(int personID);

	List<Map<String, Object>> selectAllPerson();	

}
