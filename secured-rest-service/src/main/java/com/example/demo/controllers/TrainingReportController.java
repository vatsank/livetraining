package com.example.demo.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class TrainingReportController {

	@GetMapping(path = "/review")
	public String review() {
		
		return "Review of The Trainings Conducted 2020-2021";
	}
	
	@GetMapping(path = "/report")
	public String report() {
		
		return "Summary of FeedBacks for 2020-2021";

	}

	@GetMapping(path = "/report/2020")
	@Secured({"ROLE_ADMIN"})
	public String reportForYear() {
		
		return "2020-2021";

	}

}
