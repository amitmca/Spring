package com.cg.ssp;

/**
 * @author Amit Bhalerao
 * Spring Boot Application to start the application
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FriendsManagementApplication extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(FriendsManagementApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(FriendsManagementApplication.class, args);
	}
}
