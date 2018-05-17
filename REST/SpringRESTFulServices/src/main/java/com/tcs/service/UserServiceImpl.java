package com.tcs.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tcs.dao.Userdao;
import com.tcs.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	Userdao userDao;

	@Override
	public User getUser(int id) {
		return userDao.getUser(id);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	@Override
	public List<User> listUser() {
		return userDao.listUsers();
	}

	@Override
	public void deleteUser(int id) {
		userDao.deleteUser(id);

	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);

	}
	
	@Override
    public User validateUser(User usr) {
        return userDao.validateUser(usr);
    }

}
