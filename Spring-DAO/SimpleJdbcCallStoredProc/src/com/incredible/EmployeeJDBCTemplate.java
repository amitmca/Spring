package com.incredible;

import java.math.BigDecimal;
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
				.withProcedureName("EMPLOYEE_SELECT");
	}

	public Employee getEmployeeDetails(Integer id) {
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("p_id", id);
		Map<String, Object> out = jdbcCall.execute(in);
		Employee e = new Employee();
		e.setId(id);
		e.setName((String) out.get("P_NAME"));
		e.setSalary((BigDecimal)out.get("P_SALARY"));
		return e;
	}
}
