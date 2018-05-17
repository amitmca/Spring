package roseindia.net.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import roseindia.net.model.Registration;
import roseindia.net.service.AppService;

@Controller
public class AppController {

	@Autowired
	public AppService appService;

	public void setAppService(AppService appService) {
		this.appService = appService;
	}

	@RequestMapping("/load-form")
	public String loadForm(Model model, Registration registration) {
		model.addAttribute("registration", registration);
		model.addAttribute("courses", appService.getAllCourses());
		return "student/registration";
	}

	@RequestMapping("/add-update")
	public String addUpdate(Model model,
			@ModelAttribute("registration") Registration registration) {
		appService.addStudent(registration);
		return "student/success";
	}
}