package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringSecurityController {

	@RequestMapping("/userlogin")
	public String userValidation() {
		return "User: Successfully logged in!";
	}

	@RequestMapping("/adminlogin")
	public String adminValidation() {
		return "Admin: Successfully logged in!";
	}
}