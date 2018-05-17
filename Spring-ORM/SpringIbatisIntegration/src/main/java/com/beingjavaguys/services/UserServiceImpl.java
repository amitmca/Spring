package com.beingjavaguys.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.beingjavaguys.dao.UserDao;
import com.beingjavaguys.domain.User;

public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userdao;

	@Override
	public void insertData(User user) {
		userdao.insertData(user);
	}

	@Override
	public List<User> getUserList() {
		return userdao.getUserList();
	}

	@Override
	public void deleteData(Long id) {
		userdao.deleteData(id);

	}

	@Override
	public User getUser(Long id) {
		return userdao.getUser(id);
	}

	@Override
	public void updateData(User user) {
		userdao.updateData(user);

	}

}
