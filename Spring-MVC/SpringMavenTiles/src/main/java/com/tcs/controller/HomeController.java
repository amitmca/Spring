package com.tcs.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tcs.domain.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale,Model model) {
		System.out.println("inside /");
		User usr = new User();
		model.addAttribute("usr", usr);
		return "addemp";
	}

	@RequestMapping(value = "addemp", method = RequestMethod.GET)
	public String addEmployee(@ModelAttribute("usr") User usr,
			BindingResult errors,Locale locale, Model model) {
		System.out.println("inside addEmployee");
		logger.info("Inside addEmployee");
		return "addemp";
	}

	@RequestMapping(value = "listemp", method = RequestMethod.GET)
	public String listOfEmployees(Locale locale, Model model) {
		System.out.println("inside listOfEmployees");
		logger.info("Inside listOfEmployees");
		return "listemp";
	}

}
