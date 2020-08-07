package com.example.demo.controllers;

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
}
