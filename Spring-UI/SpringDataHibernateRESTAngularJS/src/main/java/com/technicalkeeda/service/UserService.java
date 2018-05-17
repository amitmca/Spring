package com.technicalkeeda.service;

import java.util.List;
import com.technicalkeeda.bean.User;

public interface UserService {
	
	public User findById(int id);
	
	public User saveUser(User user);
	
	public User updateUser(User user);
	
	public User deleteUserById(int id);

	public List<User> findAllUsers(); 
		
}
