package roseindia.net.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import roseindia.net.domain.Course;
import roseindia.net.model.Registration;
import roseindia.net.service.AppService;

public class AppServiceImpl implements AppService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Course> getAllCourses() {
		/* here you will call a DAO Class */
		Course c1 = new Course(1, "BCA");
		Course c2 = new Course(2, "MCA");
		Course c3 = new Course(3, "B.Tech");
		Course c4 = new Course(4, "M.Tech");
		Course c5 = new Course(5, "BBA");
		Course c6 = new Course(5, "MBA");
		List<Course> courses = new ArrayList<Course>();
		courses.add(c1);
		courses.add(c2);
		courses.add(c3);
		courses.add(c4);
		courses.add(c5);
		courses.add(c6);
		return courses;
	}

	public void addStudent(Registration registration) {
		try {
			String sql = "INSERT INTO student(name,course,age,address) values(?,?,?,?)";
			jdbcTemplate.update(sql, new Object[] { registration.getName(),
					registration.getCourse(), registration.getAge(),
					registration.getAddress() });
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}