package com.test.cargomanagementservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
	
	public static final String RESOURCE_ID = "cgk_backoffice_apis";
	
// 	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		// TODO Auto-generated method stub
		super.configure(resources);
		System.out.println("ResourceServerConfiguration configure(ResourceServerSecurityConfigurer)");
//		resources.resourceId(RESOURCE_ID).stateless(true);
	}

}
