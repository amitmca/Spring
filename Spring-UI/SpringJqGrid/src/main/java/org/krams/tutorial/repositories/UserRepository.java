package org.krams.tutorial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.krams.tutorial.domain.User;
 
public interface UserRepository extends JpaRepository<User, Integer>{
}