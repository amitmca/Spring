package com.technicalkeeda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.technicalkeeda.bean.User;
 
public interface UserRepository extends JpaRepository<User, Integer>{
}