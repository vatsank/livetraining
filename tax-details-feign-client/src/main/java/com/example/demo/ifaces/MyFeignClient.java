package com.example.demo.ifaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("TAX-DETAILS-SERVICE")
public interface MyFeignClient {

	@RequestMapping(method = RequestMethod.GET,produces = "application/json",
			 path = "/api/v1/taxdetails")
	public String findAll() ;
	
	
}
