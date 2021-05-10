package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication2 {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication2.class, args);
	}

}

@RestController
class HomeController  {
	
	@GetMapping("/project2")
	public String test() {
		return "Spring Boot Project 2";
	}
}