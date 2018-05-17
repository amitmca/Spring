package com.javatpoint;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class EmpDao {
	SimpleJdbcTemplate template;

	public EmpDao(SimpleJdbcTemplate template) {
		this.template = template;
	}
	
	public int saveEmployee(Emp e) {
		String query = "insert into employee values(?,?,?)";
		return template.update(query,e.getId(),e.getName(), e.getSalary());
	}
	
	public int updateEmployee(Emp e) {
		String query = "update employee set name=?,salary = ?  where id=?";
		return template.update(query, e.getName(), e.getSalary(),e.getId());
	}

	public int deleteEmployee(int id) {
		String query = "delete from employee where id= ? ";
		return template.update(query,id);
	}

}
