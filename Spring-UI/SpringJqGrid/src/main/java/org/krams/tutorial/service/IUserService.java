package org.krams.tutorial.service;

import java.util.List;
import org.krams.tutorial.domain.User;

public interface IUserService {
	public List<User> getAll();

	public User get(int id);

	public User add(User user);

	public User delete(int id);

	public User edit(User user);
}