package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CabDriverController {

	
	
	@RequestMapping("/")
	public String init(Model model) {
		
		model.addAttribute("majHeading", "Bharath Taxi Service");
		return "index";
	}

}
