package com.tcs.service;

import java.util.List;
import com.tcs.model.User;

public interface UserService {
	public User getUser(int id);

	public void updateUser(User user);

	public List<User> listUser();

	public void deleteUser(int id);

	public void addUser(User user);
	
	public User validateUser(User usr); 

}
