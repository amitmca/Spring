package com.tcs.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tcs.model.User;

@Repository
public class UserdaoImpl implements Userdao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public User getUser(int id) {
		User user = (User) getCurrentSession().get(User.class, id);
		return user;
	}

	@Override
	public List<User> listUsers() {
		return getCurrentSession().createQuery("From User").list();
	}

	@Override
	public void deleteUser(int id) {
		User user = getUser(id);
		getCurrentSession().delete(user);
	}

	@Override
	public void addUser(User user) {
		getCurrentSession().save(user);

	}

	@Override
	public void updateUser(User user) {
		getCurrentSession().update(user);

	}
	
	@Override
	public User validateUser(User usr) {
		Query query = getCurrentSession().createQuery("from User where username= :username and password= :password");
		
		query.setParameter("username",usr.getUsername());
		query.setParameter("password",usr.getPassword());
		
		List list = query.list();
		if (list.size() > 0) {
			usr = (User) list.get(0);
			usr.setValid(true);

		} else {
			usr.setValid(false);
		}
		return usr;
	}
}
