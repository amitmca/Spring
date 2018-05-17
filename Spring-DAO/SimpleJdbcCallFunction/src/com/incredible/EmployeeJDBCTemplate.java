package com.incredible;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public class EmployeeJDBCTemplate {
	private DataSource dataSource;
	private SimpleJdbcCall jdbcCall;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcCall = new SimpleJdbcCall(dataSource)
				.withFunctionName("MYFUNCTION");
	}

	public Employee getEmployeeDetails(Integer id) {
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("p_id", id);
		Map<String, Object> out = jdbcCall.execute(in);
		Employee e = new Employee();
		
		for( Map.Entry<String,Object> entry : out.entrySet()){
			  String value = (String) entry.getValue();
			  e.setName(value);
			}
		
		e.setId(id);
		return e;
	}
}
