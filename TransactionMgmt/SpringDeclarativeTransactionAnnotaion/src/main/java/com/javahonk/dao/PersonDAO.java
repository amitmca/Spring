package com.javahonk.dao;

import java.sql.Types;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.javahonk.di.bean.Person;


public class PersonDAO implements IPersonDAO {

	private JdbcTemplate jdbcTemplate;

	@Transactional(rollbackFor = MyException.class)
	public void insertUser(Person person) throws MyException {
		String inserQuery = "INSERT INTO person(First_Name, "
				+ "Last_Name, Street_Name, City, State, Country) "
				+ "VALUES(?, ?, ?, ?, ?, ?)";
		Object[] params = new Object[] { person.getFirstName(),
				person.getLastName(), person.getStreet(), person.getCity(),
				person.getState(), person.getCountry() };
		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
				Types.VARCHAR, Types.VARCHAR, Types.VARCHAR };
		int value = jdbcTemplate.update(inserQuery, params, types);
		System.out.println("\nPerson inserted to the table");
		throw new MyException("Exception");
		//return value;
	}

	public void deletePerson(int personID) {

		String deletePerson = "DELETE FROM person WHERE id =?";
		Object[] params = new Object[] { personID };
		int[] types = new int[] { Types.VARCHAR };
		jdbcTemplate.update(deletePerson, params, types);
		System.out.println("\nPerson with id 1 deleted from " + "the table\n");

	}

	@Transactional(readOnly = true)
	public void selectAllPerson() {

		System.out.println("\nList of person in the table\n");

		String selectAllPerson = "SELECT * FROM person";
		List<Map<String, Object>> listOfPerson = jdbcTemplate
				.queryForList(selectAllPerson);
		for (Iterator<Map<String, Object>> iterator = listOfPerson.iterator(); iterator
				.hasNext();) {
			Map<String, Object> map = (Map<String, Object>) iterator.next();
			System.out.println(map);
		}
		System.out.println();

	}

	@Transactional(readOnly = true)
	public void selectPersonByName() {
		throw new UnsupportedOperationException();
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}