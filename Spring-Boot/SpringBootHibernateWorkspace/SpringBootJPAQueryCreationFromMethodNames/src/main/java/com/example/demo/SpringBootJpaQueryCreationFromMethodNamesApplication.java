package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@SpringBootApplication
public class SpringBootJpaQueryCreationFromMethodNamesApplication implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository; 

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaQueryCreationFromMethodNamesApplication.class, args);
	}
	
	public List<User> getUserListByFirstNameAndLastName(String firstname, String lastname){
		List<User> userList = userRepository.findByFirstnameAndLastname(firstname, lastname);
		return userList;
	}
	
	public List<User> getUserListAgeLessThan(int age){
		List<User> userList = userRepository.findByAgeLessThan(age);
		return userList;
	}
	
	public List<User> getUserListAgeGreaterThan(int age){
		List<User> userList = userRepository.findByAgeGreaterThan(age);
		return userList;
	}
	
	public List<User> getUserListFirstNameLike(String firstname){
		List<User> userList = userRepository.findByFirstnameLike(firstname);
		return userList;
	}
	
	public List<User> getActiveUserList(){
		List<User> userList = userRepository.findByActiveTrue();
		return userList;
	}
	
	public List<User> getFirstnameIgnoreCaseUserList(){
		List<User> userList = userRepository.findByFirstnameIgnoreCase("amey");
		return userList;
	}
	
	public List<User> getFirstnameEndingWith(){
		List<User> userList = userRepository.findByFirstnameEndingWith("ri");
		return userList;
	}
	
	public List<User> getLastnameContaining(){
		List<User> userList = userRepository.findByLastnameContaining("a");
		return userList;
	}
	
	public List<User> getUserListByLastname(){
		List<User> userList = userRepository.findByLastname("Bhalerao");
		return userList;
	}
	
	public List<User> getUserListByAgeBetween(){
		List<User> userList = userRepository.findByAgeBetween(4,31);
		return userList;
	}
	
	public User getUserByFirstname(){
		User user = userRepository.findByFirstname("Kasturi");
		return user;
	}
	
	public List<User> getUserListFirstnameStartsWith(String firstname){
		List<User> userList = userRepository.findByFirstnameStartsWith(firstname);
		return userList;
	}
	
	@Override
	public void run(String... args) throws Exception {
	
		//User user = new User(1,"Amit","Bhalerao",new Date(1987-02-25),32,1);
		//userRepository.save(user);
		
//		List<User> userList = getUserListByFirstNameAndLastName("Amit","Bhalerao");
//		System.out.println("Data is:");
//		userList.forEach(System.out::println);
		
//		
//		List<User> userList = getUserListAgeLessThan(10);
//		userList.forEach(System.out::println);
		
//		List<User> userList = getUserListAgeGreaterThan(4);
//		userList.forEach(System.out::println);
		
//		List<User> userList = getUserListFirstNameLike("Am");
//		userList.forEach(System.out::println);
		
//		List<User> userList = getActiveUserList();
//		userList.forEach(System.out::println);
		
//		List<User> userList = getFirstnameIgnoreCaseUserList();
//		userList.forEach(System.out::println);
		
//		List<User> userList = getFirstnameEndingWith();
//		userList.forEach(System.out::println);
		
//		
//		 List<User> userList = getLastnameContaining();
//		 userList.forEach(System.out::println);
		
		/*
		 * List<User> userList = getUserListByLastname();
		 * userList.forEach(System.out::println);
		 */
		
		/*
		 * List<User> userList = getUserListByAgeBetween();
		 * userList.forEach(System.out::println);
		 */
		
		/*
		 * User user = getUserByFirstname(); System.out.println(user);
		 */
		
		 List<User> userList = getUserListFirstnameStartsWith("Am");
		 userList.forEach(System.out::println);
	}

}
