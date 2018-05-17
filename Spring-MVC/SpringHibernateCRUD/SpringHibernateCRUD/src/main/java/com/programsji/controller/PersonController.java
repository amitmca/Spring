package com.programsji.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.programsji.bo.Person;
import com.programsji.service.PersonService;

import java.util.List;

@Controller
public class PersonController {

	@Autowired
	PersonService service;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute("person", new Person());
		return "addperson";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("person") Person person,
			BindingResult br, Model model) {
		if (br.hasErrors()) {
			return "addperson";
		}
		if (person.getId() > 0) {
			service.updatePerson(person);
		} else {
			service.addPerson(person);
		}
		return "redirect:list";
	}

	@RequestMapping(value = { "/list", "/" }, method = RequestMethod.GET)
	public String list(Model model) {
		List<Person> personlist = service.listPerson();
		model.addAttribute("personlist", personlist);
		return "listperson";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable Integer id, Model model) {
		model.addAttribute("person", service.getPerson(id));
		return "addperson";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Integer id) {

		service.deletePerson(id);
		return "redirect:/list";
	}
}
