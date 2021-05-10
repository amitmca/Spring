package com.example.log4j2demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingDemoController {

	private static final Logger log = LogManager.getLogger(LoggingDemoController.class);

	@GetMapping("/greeting")
	public String sayHello() {
		log.info("Info log statement for LoggingDemoController");
		log.warn("Warn log statement for LoggingDemoController");
		log.error("Error log statement for LoggingDemoController");
		return "greeting";
	}
}
