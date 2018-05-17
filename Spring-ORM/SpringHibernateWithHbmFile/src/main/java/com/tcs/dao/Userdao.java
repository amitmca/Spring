package com.tcs.dao;

import java.util.List;

import com.tcs.model.User;

public interface Userdao {
	public User getUser(int id);

	public List<User> listUsers();

	public void deleteUser(int id);

	public void addUser(User user);

	public void updateUser(User user);

	public User validateUser(User user); 
}
