package com.example.demo.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication()
		.withUser("india")
		.password("{noop}india")
		.roles("user").and().withUser("nepal").password("{noop}nepal").roles("admin");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http.authorizeRequests()
		.antMatchers("/review")
		.permitAll().
		antMatchers("/report/**")
		.authenticated().and()
		.formLogin().and().logout().logoutSuccessUrl("/report")
		.invalidateHttpSession(true)
		.deleteCookies("JSESSIONID").and().csrf().
		disable();

		
//		http.authorizeRequests()
//		.antMatchers("/review")
//		.permitAll().
//		antMatchers("/report")
//		.authenticated().and()
//		.httpBasic().and().csrf().
//		disable();
	}

	
	
}
