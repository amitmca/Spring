package roseindia.net.domain.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import roseindia.net.model.Registration;

public class StudentMapping implements RowMapper<Registration> {

	public Registration mapRow(ResultSet resultSet, int rowNum)
			throws SQLException {
		Registration student = new Registration();
		student.setRollNo(resultSet.getInt("roll_no"));
		student.setName(resultSet.getString("name"));
		student.setCourse(resultSet.getString("course"));
		student.setAge(resultSet.getInt("age"));
		student.setAddress(resultSet.getString("address"));
		return student;
	}
}