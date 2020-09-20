package com.example.demo.controllers;

import javax.annotation.security.RolesAllowed;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

	
	@GetMapping(path = "/customers")
	@Secured("ROLE_ADMIN")
	//@RolesAllowed(value = "{ROLE_ADMIN}")
	public String getCustomer() {
		
		return "Customer Details Will be updated";
	}
	
	@GetMapping(path = "/payments")
	public String getPayments() {
		
		return "Payment Details Will be updated";
	}
	
}
