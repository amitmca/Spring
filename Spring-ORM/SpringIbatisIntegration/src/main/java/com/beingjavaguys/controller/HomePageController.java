package com.beingjavaguys.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.beingjavaguys.domain.User;
import com.beingjavaguys.services.UserService;

@Controller
public class HomePageController {

	@Autowired
	UserService userService;

	@RequestMapping("/addregister")
	public ModelAndView getRegisterForm(@ModelAttribute("user") User user,
			BindingResult result) {
		return new ModelAndView("register");
	}

	@RequestMapping("/register")
	public ModelAndView registerUser(@ModelAttribute User user,
			BindingResult result) {

		List<String> genderList = new ArrayList<String>();
		genderList.add("male");
		genderList.add("female");

		List<String> cityList = new ArrayList<String>();
		cityList.add("delhi");
		cityList.add("gurgaon");
		cityList.add("meerut");
		cityList.add("noida");

		Map<String, List> map = new HashMap<String, List>();
		map.put("genderList", genderList);
		map.put("cityList", cityList);
		return new ModelAndView("register", "map", map);
	}

	@RequestMapping("/insert")
	public String inserData(@ModelAttribute User user) {
		if (user != null)
			userService.insertData(user);
		return "redirect:/getList";
	}

	@RequestMapping("/getList")
	public ModelAndView getUserLIst() {
		List<User> userList = userService.getUserList();
		return new ModelAndView("userList", "userList", userList);
	}

	@RequestMapping("/edit")
	public ModelAndView editUser(@RequestParam Long id,
			@ModelAttribute User user) {

		user = userService.getUser(id);

		List<String> genderList = new ArrayList<String>();
		genderList.add("male");
		genderList.add("female");

		List<String> cityList = new ArrayList<String>();
		cityList.add("delhi");
		cityList.add("gurgaon");
		cityList.add("meerut");
		cityList.add("noida");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("genderList", genderList);
		map.put("cityList", cityList);
		map.put("user", user);

		return new ModelAndView("edit", "map", map);

	}

	@RequestMapping("/update")
	public String updateUser(@ModelAttribute User user) {
		userService.updateData(user);
		return "redirect:/getList";

	}

	@RequestMapping("/delete")
	public String deleteUser(@RequestParam Long id) {
		System.out.println("id = " + id);
		userService.deleteData(id);
		return "redirect:/getList";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}

}
