package com.example.demo.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableAuthorizationServer
public class PaymentAuthorizationConfig extends 
             AuthorizationServerConfigurerAdapter {

	@Autowired
	TokenStore tokenStore;
	
	@Autowired
	AuthenticationManager manager;

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		
		clients.inMemory().withClient("my-client")
		.authorizedGrantTypes("password","authorization_code",
				     "refresh_token","implicit")
		.scopes("read","write").secret("{noop}secret")
		  .accessTokenValiditySeconds(3000)
		    .refreshTokenValiditySeconds(6000);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore).authenticationManager(manager);
	}
	
	
	
}
