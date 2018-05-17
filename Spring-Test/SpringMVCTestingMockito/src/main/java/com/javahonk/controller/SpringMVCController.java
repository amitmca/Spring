package com.javahonk.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javahonk.services.IPersonService;


@Controller
public class SpringMVCController {
	
	@Autowired 
	IPersonService transformService;
	
	private static final Logger logger = Logger.getLogger(SpringMVCController.class);
	
	@RequestMapping(value = "/databasetest")
	public @ResponseBody List<Map<String, Object>> databasetest() {
		
		logger.debug("Enter databasetest method");
		return transformService.selectAllPerson();
	}


}
