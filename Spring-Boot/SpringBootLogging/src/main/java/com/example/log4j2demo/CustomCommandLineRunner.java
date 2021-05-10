package com.example.log4j2demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Component
public class CustomCommandLineRunner implements CommandLineRunner {

	private static final Logger logger = LogManager.getLogger(Log4j2DemoApplication.class);

	public void run(String... args) throws Exception {
		logger.info("Custom command line runner is excuted with command line arguments: {}", Arrays.toString(args));
	}
}