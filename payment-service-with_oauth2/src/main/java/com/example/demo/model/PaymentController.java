package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

	@Autowired
	Payment payment;
	
	@GetMapping("/api/payments/{id}")
	public Payment getPayment(@PathVariable("id") int id) {
		
		payment.setId(id);
		payment.setAmount(4500);
		payment.setCustomerName("Ramesh");
		
		return payment;
	}
}
