package com.tcs.controller;

import java.util.List;
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

import com.tcs.domain.User;
import com.tcs.userservice.UserService;

@Controller
@SessionAttributes("usr")
public class LoginController {

	private Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		model.addAttribute("usr", new User());
		User usr = new User();
		model.addAttribute("usr", usr);
		return "login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String showLoginPage(@ModelAttribute("usr") User usr,
			BindingResult errors, Locale locale, Model model) {
		logger.info("Inside Login Page");
		if (errors.hasErrors()) {
			return "login";
		}
		logger.info("usr username:" + usr.getUsername());
		logger.info("usr password:" + usr.getPassword());

		List<User> userSearched = userService.validateUser(usr.getUsername(),
				usr.getPassword());
		if (userSearched.size() > 0) {
			usr = userSearched.get(0);
			usr.setValid(true);
			logger.info("match");
		} else {
			usr.setValid(false);
			logger.info("no match");
		}

		if (usr.isValid()) {
			return "welcome";
		} else {
			model.addAttribute("invalidLogin", "true");
			return "login";
		}
	}

	@RequestMapping(value = "welcome", method = RequestMethod.GET)
	public String welCome(@ModelAttribute("usr") User usr,
			BindingResult errors, Locale locale, Model model) {
		logger.info("Inside Welcome Page");
		return "welcome";
	}

	@RequestMapping(value = "/logOut", method = RequestMethod.GET)
	public String logOut(Model model, HttpSession httpSession) {
		httpSession.invalidate();
		model.addAttribute("usr", new User());
		return "login";
	}
}
