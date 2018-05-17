package com.technicalkeeda.service;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.technicalkeeda.bean.User;
import com.technicalkeeda.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserRepository userRepository;

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public User findById(int id) {
		return userRepository.findOne(id);
	}

	@Override
	public User saveUser(User user) {
		User createdUser = user;
		return userRepository.save(createdUser);
	}

	@Override
	@Transactional
	public User updateUser(User user) {
		User updatedUser = userRepository.findOne(user.getId());
		updatedUser.setId(user.getId());
		updatedUser.setUsername(user.getUsername());
		updatedUser.setAddress(user.getAddress());
		updatedUser.setEmail(user.getEmail());
		System.out.println("Updated User Details:");
		System.out.println(updatedUser.getId()+"\t"+updatedUser.getUsername() + "\t"
				+ updatedUser.getAddress() + "\t"
				+ updatedUser.getEmail());
		return updatedUser;
	}

	
	
	@Override
	public User deleteUserById(int id) {
		User deletedUser = userRepository.findOne(id);
		userRepository.delete(deletedUser);
		return deletedUser;
	}

	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}
	
}