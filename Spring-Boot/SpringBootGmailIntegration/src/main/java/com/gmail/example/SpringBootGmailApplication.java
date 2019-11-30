package com.gmail.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

@SpringBootApplication
public class SpringBootGmailApplication implements CommandLineRunner {

	@Autowired
	private JavaMailSender javaMailSender;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootGmailApplication.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println("Sending Email...");
		try {
			sendEmail();
			sendEmailWithAttachment();

		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Done");

	}

	void sendEmail() {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo("amitbaramatimca@gmail.com");
		msg.setSubject("Testing from Spring Boot");
		msg.setText("Hello World \n Spring Boot Email");
		javaMailSender.send(msg);
	}

	void sendEmailWithAttachment() throws MessagingException, IOException {
		MimeMessage msg = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg, true);
		helper.setTo("amitbaramatimca@gmail.com");
		helper.setSubject("Testing from Spring Boot");
		helper.setText("<h1>Check attachment for image!</h1>", true);
		helper.addAttachment("my_photo.png", new ClassPathResource("android.png"));
		javaMailSender.send(msg);
	}
}
