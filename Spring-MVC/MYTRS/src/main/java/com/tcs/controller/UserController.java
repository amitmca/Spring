package com.tcs.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tcs.domain.User;
import com.tcs.userservice.UserService;

import org.apache.log4j.Logger;

@Controller

public class UserController {

	private Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@RequestMapping(value = "userList", method = RequestMethod.GET)
	public String listOfUsers(@ModelAttribute("usr") User usr, BindingResult errors,Locale locale, Model model) {
		logger.info("Inside userList");
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		User user = new User();
		model.addAttribute("user", user);
		return "userList";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("usr") User usr,
			BindingResult errors, Model model) {
		model.addAttribute("showSaveMessage", "true");
		userService.saveUser(usr);
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		User user = new User();
		model.addAttribute("user", user);
		return "userList";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editUser(@RequestParam String id,
			@ModelAttribute("usr") User usr, BindingResult errors, Model model) {
		model.addAttribute("showSaveMessage", "false");
		List<User> userToEdit = userService.getUserByUserId(id);
		model.addAttribute("userToEdit", userToEdit);
		return "edit";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute("usr") User usr,
			BindingResult errors, Model model) {
		userService.updateUser(usr);
		model.addAttribute("showUpdateMessage", "true");
		model.addAttribute("usr", new User());
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		User user = new User();
		model.addAttribute("user", user);
		return "userList";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteUser(@RequestParam String id,
			@ModelAttribute("usr") User usr, BindingResult errors, Model model) {
		userService.deleteUser(id);
		model.addAttribute("showDeleteMessage", "true");
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		User user = new User();
		model.addAttribute("user", user);
		return "userList";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchUser(@RequestParam("username") String username,
			@ModelAttribute("usr") User usr, BindingResult errors, Model model) {
		logger.info("username is::"+username);
		List<User> userSearched=userService.getUserByUsername(username);
		model.addAttribute("userSearched", userSearched);
		model.addAttribute("showSearchedUser", "true");
		return "welcome";
	}
	
	@RequestMapping(value = "grid", method = RequestMethod.GET)
	public String showGrid(Locale locale, Model model) {
		logger.info("Inside grid Page");
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		return "grid";
	}
	
	@RequestMapping(value = "test", method = RequestMethod.GET)
	public String showTestPage(Locale locale, Model model) {
		logger.info("Inside test Page");
		return "test";
	}
	
}
