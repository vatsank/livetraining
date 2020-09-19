package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class CustomerController {

	
	@Autowired
	private Customer customer;
	
	@Value("${server.port}")
	private String port;
	
	@GetMapping(path = "/customers/{id}")
	@Operation(description = "Return the Customer Details")
	public Customer  showCustomer(@PathVariable("id") int id) throws InterruptedException {
		
		if(id < 5) {
		   customer.setId(Integer.parseInt(port));
		   customer.setName("Ramesh");
		} else {

			Thread.sleep(5000);
//    			customer.setId(Integer.parseInt(port));
//			   customer.setName("Vikas -Late Response");

		}
		return customer;
	}
}
