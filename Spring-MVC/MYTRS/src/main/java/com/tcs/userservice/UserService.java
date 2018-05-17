package com.tcs.userservice;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tcs.domain.User;

public interface UserService {
	
	public void saveUser(User usr);
	public List<User> getAllUsers();
	public List<User> getUserByUserId(String userId);
	public void updateUser(User user);
	public void deleteUser(String userId);
	public List<User> getUserByUsername(String username);
	public List<User> validateUser(@Param("username") String username,@Param("password") String password);
	}
