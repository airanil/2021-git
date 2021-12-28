package com.test.cargomanagementservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;



@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
	

    @Value("${jwt.signing.key}")
    public String SIGNING_KEY;

	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Bean
	public PasswordEncoder encoder() {
		System.out.println("AuthorizationServerConfiguration encoder()");
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		System.out.println("AuthorizationServerConfiguration accessTokenConverter()");
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey(SIGNING_KEY);
		return converter;
	}
	
	@Bean
	public TokenStore tokenStore() {
		System.out.println("AuthorizationServerConfiguration tokenStore()");
		return new JwtTokenStore(accessTokenConverter());
	}
	
	@Bean
	@Primary
	public DefaultTokenServices tokenServices() {
		System.out.println("AuthorizationServerConfiguration tokenServices()");
		DefaultTokenServices tokenServices = new DefaultTokenServices();
		tokenServices.setTokenStore(tokenStore());
		tokenServices.setTokenEnhancer(accessTokenConverter());
		tokenServices.setSupportRefreshToken(true);
		tokenServices.setAccessTokenValiditySeconds(600);
		tokenServices.setRefreshTokenValiditySeconds(1200);
		return tokenServices;
	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		// TODO Auto-generated method stub
//		super.configure(endpoints);
		System.out.println("AuthorizationServerConfiguration configure(AuthorizationServerEndpointsConfigurer)");
		endpoints.authenticationManager(this.authenticationManager).tokenServices(tokenServices())
			.tokenStore(tokenStore()).accessTokenConverter(accessTokenConverter());
	}
	
	@Override
	public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {
		// TODO Auto-generated method stub
//		super.configure(clients);
		System.out.println("AuthorizationServerConfiguration configure(ClientDetailsServiceConfigurer)");
		configurer.inMemory().withClient("clientapp").secret("password")
			.authorizedGrantTypes("password", "refresh_token").scopes("backofficeclient")
			;
	}
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer securityConfigurer) throws Exception {
		// TODO Auto-generated method stub
//		super.configure(security);
       // here tokenKeyAcess("permitAll()") means -> who all can access token, 
	   // 
		System.out.println("AuthorizationServerConfiguration configure(AuthorizationServerSecurityConfigurer)");
		securityConfigurer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()")
			.allowFormAuthenticationForClients();
	}


	

}
