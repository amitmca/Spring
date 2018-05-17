package com.javahonk.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.javahonk.dao.IPersonDAO;
import com.javahonk.domain.Person;

public class PersonServiceImpl implements IPersonService{
	
	@Autowired
	IPersonDAO transformDAO;

	@Override
	public int insertPerson(Person person) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatePerson(Person person) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deletePerson(int personID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Map<String, Object>> selectAllPerson() {
		return transformDAO.selectAllPerson();
	}	

}
