package com.srcsys;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeDao {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int saveEmployee(Employee e) {
		String query = "insert into employee values('" + e.getId() + "','"
				+ e.getName() + "','" + e.getSalary() + "')";
		return jdbcTemplate.update(query);
	}

	public int updateEmployee(Employee e) {
		String query = "update employee set name='" + e.getName()
				+ "',salary='" + e.getSalary() + "' where id='" + e.getId()
				+ "' ";
		return jdbcTemplate.update(query);
	}

	public int deleteEmployee(int id) {
		String query = "delete from employee where id='" + id + "' ";
		return jdbcTemplate.update(query);
	}

	public Boolean saveEmployeeByPreparedStatement(final Employee e) {
		String query = "insert into employee values(?,?,?)";
		return jdbcTemplate.execute(query,
				new PreparedStatementCallback<Boolean>() {
					@Override
					public Boolean doInPreparedStatement(PreparedStatement ps)
							throws SQLException, DataAccessException {

						ps.setInt(1, e.getId());
						ps.setString(2, e.getName());
						ps.setFloat(3, e.getSalary());

						return ps.execute();

					}
				});
	}

	public Boolean updateEmployeeByPreparedStatement(final Employee e) {
		String query = "update employee set name = ? , salary  = ? where id = ? ";
		return jdbcTemplate.execute(query,
				new PreparedStatementCallback<Boolean>() {
					@Override
					public Boolean doInPreparedStatement(PreparedStatement ps)
							throws SQLException, DataAccessException {

						ps.setString(1, e.getName());
						ps.setFloat(2, e.getSalary());
						ps.setInt(3, e.getId());

						return ps.execute();

					}
				});
	}

	public Boolean deleteEmployeeByPreparedStatement(final int id) {
		String query = "delete from employee where id=?";
		return jdbcTemplate.execute(query,
				new PreparedStatementCallback<Boolean>() {
					@Override
					public Boolean doInPreparedStatement(PreparedStatement ps)
							throws SQLException, DataAccessException {

						ps.setInt(1, id);

						return ps.execute();

					}
				});
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {
		return jdbcTemplate.query("select * from employee",
				new EmployeeExtractor());
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployeesRowMapper() {
		return jdbcTemplate.query("select * from employee",
				new EmployeeMapper());

	}
}

@SuppressWarnings("rawtypes")
class EmployeeExtractor implements ResultSetExtractor {

	public List<Employee> extractData(ResultSet rs) throws SQLException,
			DataAccessException {

		List<Employee> list = new ArrayList<Employee>();
		while (rs.next()) {
			Employee e = new Employee();
			e.setId(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setSalary(rs.getInt(3));
			list.add(e);
		}
		return list;
	}

}

@SuppressWarnings("rawtypes")
class EmployeeMapper implements RowMapper {
	public Employee mapRow(ResultSet rs, int rownumber) throws SQLException {
		Employee e = new Employee();
		e.setId(rs.getInt(1));
		e.setName(rs.getString(2));
		e.setSalary(rs.getInt(3));
		return e;
	}
}
