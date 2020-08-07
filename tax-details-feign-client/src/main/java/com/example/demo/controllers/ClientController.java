package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ifaces.MyFeignClient;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ClientController {

	
	@Autowired
	private MyFeignClient loadBalancerClient;
	
	
	@GetMapping(path = "/fclient")
	public String getAll() {
		log.info("Feign Client Called");

		return this.loadBalancerClient.findAll();
	}
}
