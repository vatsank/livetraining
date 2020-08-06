package org.module.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.*;
@Configuration
public class MyRibbonConfig {

	@Autowired
	private IClientConfig config;
	
	
	@Bean
	public IRule rule() {
	
		return new BestAvailableRule();
		
	}
}
