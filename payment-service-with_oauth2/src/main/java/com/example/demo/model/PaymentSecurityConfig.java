package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
@EnableWebSecurity
public class PaymentSecurityConfig extends 
                       WebSecurityConfigurerAdapter {

	@Bean
	public TokenStore tokenStore() {
		return new InMemoryTokenStore();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.anonymous().disable().csrf().disable()
		   .authorizeRequests()
		     .antMatchers("/oauth/token").permitAll();
		
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
	
		return super.authenticationManagerBean();
	}

	
	@Autowired
	public void globalDetails(AuthenticationManagerBuilder builder) throws Exception {
		
		builder.inMemoryAuthentication().withUser("india")
		.password("{noop}india").roles("ADMIN")
		 .and().withUser("nepal").password("{noop}nepal").roles("USER");
	}
	
}
