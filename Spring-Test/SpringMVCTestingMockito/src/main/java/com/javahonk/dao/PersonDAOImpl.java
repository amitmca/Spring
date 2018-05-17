package com.javahonk.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.javahonk.domain.Person;

public class PersonDAOImpl implements IPersonDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

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
		String sql = "SELECT * FROM person";
		List<Map<String, Object>> listOfPerson = jdbcTemplate.queryForList(sql);
		return listOfPerson;
	}


}
