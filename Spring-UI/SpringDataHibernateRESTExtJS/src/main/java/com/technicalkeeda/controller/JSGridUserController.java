package com.technicalkeeda.controller;
 
import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.technicalkeeda.bean.User;
import com.technicalkeeda.service.UserService;
 
@Controller
@RequestMapping(value = "/JsGridEx")
public class JSGridUserController {
 
    @Autowired
    UserService userService;  //Service which will do all data retrieval/manipulation work
     
    @RequestMapping(value = "/jsgrid", method = RequestMethod.GET)
   	public String loadJsGrid(Locale locale, Model model) {
   		return "jsgrid";
   	}
    
    //-------------------Retrieve All Users--------------------------------------------------------
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users = userService.findAllUsers();
        if(users.isEmpty()){
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
     
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/jsgridusers", method = RequestMethod.GET)
    public void  listAllUsers(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<User> users = userService.findAllUsers();
        JSONArray array=new JSONArray();
        for ( User v : users) {
        	array.add(v.getId());
        	array.add(v.getUsername());
        	array.add(v.getAddress());
        	array.add(v.getEmail());
          }
        System.out.println(array);
        response.getWriter().write(array.toJSONString());
    }
}