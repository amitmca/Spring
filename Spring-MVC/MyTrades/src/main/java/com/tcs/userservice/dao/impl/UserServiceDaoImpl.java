package com.tcs.userservice.dao.impl;
        
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tcs.controller.UserController;
import com.tcs.domain.User;
import com.tcs.userservice.dao.UserServiceDao;
import com.tcs.userservice.mybatis.UserServiceMapper;

@Component
public class UserServiceDaoImpl implements UserServiceDao{
	
	@Autowired
	private UserServiceMapper usrServiceMapper;
	
	private Logger logger = Logger.getLogger(UserController.class);
	
	@Override
	public void saveUser(User usr) {
		usrServiceMapper.saveUser(usr);
	}
	
	@Override
	public List<User> getAllUsers() {
		List<User> user = usrServiceMapper.getAllUsers();
		return user;
	}
	
	@Override
	public List<User> getUserByUserId(String userId) {
		List<User> user = usrServiceMapper.getUserByUserId(userId);
		return user;
	}
	
	@Override
	public void updateUser(User usr) {
		usrServiceMapper.updateUser(usr);
	}
	
	@Override
	public void deleteUser(String userId) {
		usrServiceMapper.deleteUser(userId);
	}
	
	@Override
	public List<User> getUserByUsername(String username) {
		List<User> user = usrServiceMapper.getUserByUsername(username);
		return user;
	}
	
	@Override
	public List<User> validateUser(String username,String password) {
		List<User> user = usrServiceMapper.validateUser(username,password);
		return user;
	}
	
}
