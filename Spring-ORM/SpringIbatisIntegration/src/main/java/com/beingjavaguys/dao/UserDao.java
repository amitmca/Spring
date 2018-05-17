package com.beingjavaguys.dao;

import java.util.List;
import com.beingjavaguys.domain.User;

public interface UserDao {
 public Long insertData(User user);
 public List<User> getUserList();
 public void updateData(User user);
 public void deleteData(Long id);
 public User getUser(Long id);

}

