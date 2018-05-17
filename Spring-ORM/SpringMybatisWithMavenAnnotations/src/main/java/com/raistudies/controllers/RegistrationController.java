package com.raistudies.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.raistudies.domain.User;
import com.raistudies.persistence.UserService;
import com.raistudies.validator.RegistrationValidator;

@Controller
@RequestMapping(value="/registration")
public class RegistrationController {
	
	private RegistrationValidator validator = null;
	private UserService userService = null;
		
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public RegistrationValidator getValidator() {
		return validator;
	}

	@Autowired
	public void setValidator(RegistrationValidator validator) {
		this.validator = validator;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "/registration";
	}

	@RequestMapping(method=RequestMethod.GET)
	public String showForm(ModelMap model,@ModelAttribute(value="user") User user){
		List<User> users = userService.getAllUser();
		model.addAttribute("users", users);
		user.setId(UUID.randomUUID().toString());
		model.addAttribute("user", user);
		return "registration";
	}

	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView add(@ModelAttribute(value="user") User user,BindingResult result){
		validator.validate(user, result);
		ModelAndView mv = new ModelAndView("registration");
		if(!result.hasErrors()){
			userService.saveUser(user);
			user = new User();
			user.setId(UUID.randomUUID().toString());
			mv.addObject("user", user);
		}
		mv.addObject("users", userService.getAllUser());
		return mv;
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute(value="user") User user,BindingResult result){
		validator.validate(user, result);
		ModelAndView mv = new ModelAndView("registration");
		if(!result.hasErrors()){
			userService.updateUser(user);
			user = new User();
			user.setId(UUID.randomUUID().toString());
			mv.addObject("user", user);
		}
		mv.addObject("users", userService.getAllUser());
		return mv;
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public ModelAndView delete(@ModelAttribute(value="user") User user,BindingResult result){
		validator.validate(user, result);
		ModelAndView mv = new ModelAndView("registration");
		if(!result.hasErrors()){
			userService.deleteUser(user.getId());
			user = new User();
			user.setId(UUID.randomUUID().toString());
			mv.addObject("user", user);
		}
		mv.addObject("users", userService.getAllUser());
		return mv;
	}
}
