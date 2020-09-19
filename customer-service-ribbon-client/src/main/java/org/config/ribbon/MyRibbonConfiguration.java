package org.config.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.netflix.client.config.IClientConfig;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;

@Configuration
public class MyRibbonConfiguration {

	@Autowired
	IClientConfig clientConfig;
	
	
	public IRule configRule(IClientConfig config) {
		
		
		return new RoundRobinRule();
	}
}
