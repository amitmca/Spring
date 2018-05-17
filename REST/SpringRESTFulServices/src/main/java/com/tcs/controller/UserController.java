package com.tcs.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tcs.model.User;
import com.tcs.service.UserService;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	UserService service;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("user") User user, BindingResult br,
			Model model) {
		if (br.hasErrors()) {
			return "welcome";
		}
		if (user.getUser_id() > 0) {
			service.updateUser(user);
			model.addAttribute("showUpdateMessage", "true");
		} else {
			service.addUser(user);
			model.addAttribute("showSaveMessage", "true");
		}

		return "redirect:userList";
	}

	@RequestMapping(value = { "userList" }, method = RequestMethod.GET)
	public String list(Model model) {
		List<User> userlist = service.listUser();
		model.addAttribute("userlist", userlist);
		return "userList";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable Integer id, Model model) {
		model.addAttribute("showUpdateMessage", "true");
		model.addAttribute("user", service.getUser(id));
		return "welcome";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Integer id, Model model) {
		service.deleteUser(id);
		model.addAttribute("showDeleteMessage", "true");
		return "redirect:/userList";
	}

	@RequestMapping(value = "grid", method = RequestMethod.GET)
	public String showGrid(Locale locale, Model model) {
		List<User> users = service.listUser();
		model.addAttribute("users", users);
		return "grid";
	}

	/* Using JSON */
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable("id") int userId) {
		User user = service.getUser(userId);
		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteUser(@PathVariable("id") int userId) {
		HttpHeaders headers = new HttpHeaders();
		User user = service.getUser(userId);
		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		service.deleteUser(userId);
		headers.add("User Deleted - ", String.valueOf(userId));
		return new ResponseEntity<User>(user, headers, HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<User>> listAllUsers() {

		HttpHeaders headers = new HttpHeaders();
		List<User> users = service.listUser();

		if (users == null) {
			return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
		}
		headers.add("Number Of Records Found", String.valueOf(users.size()));
		return new ResponseEntity<List<User>>(users, headers, HttpStatus.OK);
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST,produces = "application/json")
	public ResponseEntity<User> createEmployee(@RequestBody User user) {
		HttpHeaders headers = new HttpHeaders();
		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
		service.addUser(user);
		headers.add("User Created  - ", String.valueOf(user.getUser_id()));
		return new ResponseEntity<User>(user, headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT,produces = "application/json")
	public ResponseEntity<User> updateEmployee(@PathVariable("id") int userId,
			@RequestBody User user) {
		HttpHeaders headers = new HttpHeaders();
		User isExist = service.getUser(userId);
		if (isExist == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		} else if (user == null) {
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
		service.updateUser(user);
		headers.add("Employee Updated  - ", String.valueOf(userId));
		return new ResponseEntity<User>(user, headers, HttpStatus.OK);
	}

}
