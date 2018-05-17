package org.krams.tutorial.service;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.krams.tutorial.domain.User;
import org.krams.tutorial.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional
public class UserService implements IUserService   {
 	
	protected static Logger logger = Logger.getLogger("service");

	@Resource
	private UserRepository userRepository;
		
	public List<User> getAll() {
		logger.debug("Retrieving all users");
		return userRepository.findAll();
	}
	
	public User get(int id ) {
		logger.debug("Retrieving an existing user");
		return userRepository.findOne(id);
	}

	public User add( User user ) {
		logger.debug("Adding a new user");
		User createdUser = user;
		return userRepository.save(createdUser);
	}
	
	public User delete(int id) {
		logger.debug("Deleting an existing user");
		User deletedUser = userRepository.findOne(id);
		userRepository.delete(deletedUser);
		return deletedUser;

	}
 	
	public User edit( User user ) {
		logger.debug("Editing an existing user");
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

}
