package com.tcs.controller;

import java.util.Locale;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tcs.model.User;
import com.tcs.service.UserService;

@Controller
@SessionAttributes("usr")
public class LoginController {

	private Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		model.addAttribute("user", new User());
		User user = new User();
		model.addAttribute("user", user);
		return "login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String showLoginPage(@ModelAttribute("user") User usr,
			BindingResult errors, Locale locale, Model model,HttpSession session) {
		logger.info("Inside Login Page");
		if (errors.hasErrors()) {
			return "login";
		}
		logger.info("usr username:" + usr.getUsername());
		logger.info("usr password:" + usr.getPassword());

		usr=userService.validateUser(usr);
		String firstName = usr.getFirstName(); 
		session.setAttribute("firstName", firstName);

		if (usr.isValid()) {
			return "welcome";
		} else {
			model.addAttribute("invalidLogin", "true");
			return "login";
		}
	}

	@RequestMapping(value = "welcome", method = RequestMethod.GET)
	public String welCome(@ModelAttribute("user") User user,
			BindingResult errors, Locale locale, Model model) {
		logger.info("Inside Welcome Page");
		return "welcome";
	}

	@RequestMapping(value = "/logOut", method = RequestMethod.GET)
	public String logOut(Model model, HttpSession httpSession) {
		httpSession.invalidate();
		model.addAttribute("user", new User());
		return "login";
	}
	
}
