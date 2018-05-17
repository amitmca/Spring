package roseindia.net.service;

import java.util.List;

import roseindia.net.domain.Course;
import roseindia.net.model.Registration;

public interface AppService {
	public List<Course> getAllCourses();

	public void addStudent(Registration registration);
	//public Registration studentSearch(Integer rollNo);
	//public void updateStudent(Registration registration);
	//public void delete(Integer rollNo);	
}