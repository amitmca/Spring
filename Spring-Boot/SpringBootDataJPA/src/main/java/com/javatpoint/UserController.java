package com.javatpoint;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;  

@RestController  
public class UserController {  
    @Autowired  
    private UserService userService;   
    
    @RequestMapping("/")  
    public List<UserRecord> getAllUser(){  
        return userService.getAllUsers();  
    }     
    
    @RequestMapping(value="/add-user", method=RequestMethod.POST)  
    public void addUser(@RequestBody UserRecord userRecord){  
        userService.addUser(userRecord);  
    }  
    
    @RequestMapping(value="/user/{id}", method=RequestMethod.GET)  
    public UserRecord getUser(@PathVariable String id){  
        return userService.getUser(id);  
    }  
    
    @RequestMapping(value="/user/delete/{id}", method=RequestMethod.DELETE)  
    public void deleteUser(@PathVariable String id){  
        userService.deleteUser(id);  
    }  
    
    @RequestMapping(value="/update-user/{id}", method=RequestMethod.PUT)  
    public void updateUser(@RequestBody UserRecord userRecord){  
        userService.updateUser(userRecord);  
    }  
}  