package com.example.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Driver;

@Controller
public class CabDriverController {

	@Autowired
	private Driver driver;
	
	
	@Autowired
	private RestTemplate template;
	
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
	public String onSubmit(@Valid @ModelAttribute("command") Driver driver,
			       BindingResult result) {
		
		 if(result.hasErrors()) {
			 return "addCabDriver";
		 } else {
				return "showResult"; 
		 }
		
			
	}
	
	@ModelAttribute("locationList")
	public String[]  locationList() {
		
		return new String[] {"Chennai","Mumbai","Pune","Hyderabd"};
	}
	
	@GetMapping(path="/drivers",produces = "application/json" )
	public String getAllDrivers(Model model) {
		
//		String result  = this.template.getForObject("http://localhost:2020/api/v1/trips", 
//		           String.class);
//
//		model.addAttribute("list",result);
		 return "showTrips";
		 
//		return this.template.getForObject("http://localhost:2020/api/v1/trips", 
//				           String.class);
//		
		
		
	}
}
