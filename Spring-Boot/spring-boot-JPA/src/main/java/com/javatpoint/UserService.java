package com.javatpoint;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;  

@Service  
public class UserService {  
    @Autowired  
    @Resource
    private UserRepository userRepository;  
    public List<UserRecord> getAllUsers(){  
        return userRepository.findAll();  
    }  
    
    public UserRecord getUser(String id){  
        return userRepository.findOne(id);  
    }  
    
    public void addUser(UserRecord userRecord){  
        userRepository.save(userRecord);  
    }  
    
    public void deleteUser(String id){  
        userRepository.delete(id);  
    }  

    public UserRecord updateUser(UserRecord user) {
    	UserRecord updatedUser = userRepository.findOne(user.getId());
    	updatedUser.setId(user.getId());
    	updatedUser.setName(user.getName());
    	updatedUser.setEmail(user.getEmail());
    	System.out.println("Id="+updatedUser.getId()+"\tName="+updatedUser.getName()+"\tEmail="+updatedUser.getEmail());
		return updatedUser;
	}
}  