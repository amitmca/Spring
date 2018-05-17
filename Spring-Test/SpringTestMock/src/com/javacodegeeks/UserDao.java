package com.javacodegeeks;

import org.springframework.stereotype.Component;

/**
* DAO class for User related actions.
* @author Meraj
*/
@Component
public class UserDao {

  /**
  * Search for user using the id.
  * @param id user id
  * @return Retrieved user
  */
  public User findUserById(Long id) {
    // Find user details from database
    return new User();
  }
}