package com.test.cargoexportservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
@EnableResourceServer  // used to access resource url -> default access internally 
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
		accessTokenConverter.setSigningKey("dd05ddfd-108c-48d3-a95d-5d5432d09837");  // incript/decript based on same-key
		return accessTokenConverter;
	}
	
	@Bean
	public TokenStore tokenStore() {		
		return new JwtTokenStore(accessTokenConverter()); //inject bean
	}



}
