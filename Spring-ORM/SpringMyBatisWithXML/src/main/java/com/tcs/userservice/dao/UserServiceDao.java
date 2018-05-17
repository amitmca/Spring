package com.tcs.userservice.dao;

import java.util.List;

import com.tcs.domain.User;

public interface UserServiceDao {
	
	public void saveUser(User usr);
	public List<User> getAllUsers();
	public List<User> getUserByUserId(String userId);
	public void updateUser(User usr);
	public void deleteUser(String userId);
	public List<User> getUserByUsername(String username);
	public List<User> validateUser(String username, String password);
}
