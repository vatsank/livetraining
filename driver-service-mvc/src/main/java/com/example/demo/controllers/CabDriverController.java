package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Driver;

@Controller
public class CabDriverController {

	@Autowired
	private Driver driver;
	
	@RequestMapping("/")
	public String init(Model model) {
		
		model.addAttribute("majHeading", "Bharath Taxi Service");
		return "index";
	}

	@GetMapping("/addDriver")
	public String sendForm(Model model) {
		
		model.addAttribute("command", driver);
		return "addCabDriver";
	}
	
	@PostMapping("/drivers")
	public String onSubmit(@ModelAttribute("command") Driver driver) {
		
		
				return "showResult";
	}
}
