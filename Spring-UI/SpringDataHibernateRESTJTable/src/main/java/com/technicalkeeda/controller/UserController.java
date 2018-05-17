package com.technicalkeeda.controller;
 
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.technicalkeeda.bean.User;
import com.technicalkeeda.service.UserService;
 
@Controller
public class UserController {
 
    @Autowired
    UserService userService;  //Service which will do all data retrieval/manipulation work
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginPage(Locale locale, Model model) {
		return "users";
	}
    
    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getAllUsers() {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("Result", "OK");
        resultMap.put("Records", userService.findAllUsers());
        return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
    }
 
    @RequestMapping(value = "/save-edit", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> saveUser(@ModelAttribute User user) {
    	userService.saveUser(user);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("Result", "OK");
        resultMap.put("Record", user);
        return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
 
    }
 
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> deleteEmployee(Integer userid) {
    	userService.deleteUserById(userid);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("Result", "OK");
        return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
 
    }
}