package com.beingjavaguys.services;

import java.util.List;
import com.beingjavaguys.domain.User;

public interface UserService {

 public void insertData(User user);
 public List<User> getUserList();
 public void deleteData(Long id);
 public User getUser(Long id);
 public void updateData(User user);

}

