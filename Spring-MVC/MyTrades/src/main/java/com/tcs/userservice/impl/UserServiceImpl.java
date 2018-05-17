package com.tcs.userservice.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.controller.UserController;
import com.tcs.domain.User;
import com.tcs.userservice.UserService;
import com.tcs.userservice.dao.UserServiceDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserServiceDao userServiceDao;
	
	private Logger logger = Logger.getLogger(UserController.class);


	public void saveUser(User user) {
		userServiceDao.saveUser(user);
	}

	public List<User> getAllUsers() {
		List<User> user = (List<User>) userServiceDao.getAllUsers();
		return user;
	}

	public List<User> getUserByUserId(String userId) {
		List<User> user = (List<User>) userServiceDao.getUserByUserId(userId);
		return user;
	}
	
	public void updateUser(User user) {
	  userServiceDao.updateUser(user);
	}

	public void deleteUser(String userId) {
		userServiceDao.deleteUser(userId);
	}

	public List<User> getUserByUsername(String username) {
		List<User> user = (List<User>) userServiceDao.getUserByUsername(username);
		return user;
	}

	public List<User> validateUser(String username, String password) {
		List<User> user = (List<User>) userServiceDao.validateUser(username,password);
		return user;
	}

}
