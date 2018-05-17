package com.tcs.userservice.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tcs.domain.User;

public interface UserServiceMapper {

	public void saveUser(@Param("user") User user);
	
	public List<User> getAllUsers();
	
	public List<User> getUserByUserId(@Param("userId") String userId);
	
	public void updateUser(@Param("user") User user);
	
	public void deleteUser(@Param("userId") String userId);
	
	public List<User> getUserByUsername(@Param("username") String username);
	
	public List<User> validateUser(@Param("username") String username,@Param("password") String password);
}

