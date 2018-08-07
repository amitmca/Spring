package com.neo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.neo.entity.UserEntity;
import com.neo.mapper.UserMapper;

@RestController
//@RequestMapping("user-portal")
public class UserController {
	
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping(value="/getUsers",method=RequestMethod.GET)
	public List<UserEntity> getUsers() {
		List<UserEntity> users=userMapper.getAll();
		return users;
	}
	
    @RequestMapping(value="/getUser/{id}",method=RequestMethod.GET)
    public UserEntity getUser(@PathVariable("id") Long id) {
    	UserEntity user=userMapper.getOne(id);
        return user;
    }
    
    @RequestMapping(value="/add",method=RequestMethod.POST)
    public void save(@RequestBody UserEntity user) {
    	userMapper.insert(user);
    }
    
    @RequestMapping(value="/update/{id}",method=RequestMethod.PUT)
    public void update(@PathVariable("id") Long id,UserEntity user) {
    	UserEntity userExists=userMapper.getOne(id);
    	if(userExists != null)
    		userMapper.update(user);
    }
    
    @RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
    	userMapper.delete(id);
    }
    
    
}