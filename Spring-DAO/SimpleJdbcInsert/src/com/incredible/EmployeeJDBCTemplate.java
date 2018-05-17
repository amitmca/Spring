package com.incredible;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class EmployeeJDBCTemplate {
	private DataSource dataSource;
	SimpleJdbcInsert jdbcInsert;


	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("Employee");
	}

	 public void saveEmployee(Integer id, String name, Integer salary) {
	      Map<String,Object> parameters = new HashMap<String,Object>();
	      parameters.put("id", id);
	      parameters.put("name", name);
	      parameters.put("salary", salary);
	      
	      jdbcInsert.execute(parameters);
	      return;
	   }
}
