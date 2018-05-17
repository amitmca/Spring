package com.tcs.controller;

import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tcs.model.User;
import com.tcs.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService service;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("user") User user,
			BindingResult br, Model model) {
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

	@RequestMapping(value = { "userList"}, method = RequestMethod.GET)
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
	public String delete(@PathVariable Integer id,Model model) {
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
}
