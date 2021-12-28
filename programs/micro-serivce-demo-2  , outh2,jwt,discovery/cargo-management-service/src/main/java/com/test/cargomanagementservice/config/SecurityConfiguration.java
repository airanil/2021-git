package com.test.cargomanagementservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	@Qualifier("userDetailService")
	private UserDetailsService userDetailsService;

	
	
	@Autowired
	private PasswordEncoder passwordEncoder;


	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		System.out.println("SecurityConfiguration authenticationManagerBean()");
		return super.authenticationManagerBean();
	}


	@Bean
	public DaoAuthenticationProvider authenticationProvider(){
		DaoAuthenticationProvider authProvider=new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(passwordEncoder);
		return authProvider;


	}
	
	/// for authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {

			http.authorizeRequests()
            .antMatchers("/user").hasAnyAuthority("USER", "ADMIN")
            .antMatchers("/admin").hasAuthority("ADMIN")
			.antMatchers("/actuator/**",
						"/configuration/security",
						"/configuration/ui",
						"/swagger-ui.html",
						"/auth/**",
						"/flight/**",
						"/swagger-resources/configuration/ui", 
						"/v2/api-docs", "/api/v2/api-docs",
						"/swagger-resources/configuration/security", 
						"/swagger-resources", "/webjars/**",
						"/testForgotPwd/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin().permitAll()
            .and()
			.logout().permitAll();
			
		//	.exceptionHandling().authenticationEntryPoint(unauthorizedEntryPoint).and()
	//		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
			
	//		http.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);

// 		http.formLogin()
//   .loginPage("/login.html");
	}
	
	
	//configure / ignore web security for each web page request
	// @Override
	// public void configure(WebSecurity web) throws Exception {
	// 	// TODO Auto-generated method stub
	// 	System.out.println("SecurityConfiguration configure(WebSecurity)");
	// 	super.configure(web);
		
	// 	web.ignoring().antMatchers("/actuator/**",
	// 					"/configuration/security",
	// 					"/configuration/ui",
	// 					"/swagger-ui.html",
	// 					"/auth/**",
	// 					"/login",
	// 					"/logout",
	// 					"/flight/**",
	// 					"/swagger-resources/configuration/ui", 
	// 					"/v2/api-docs", "/api/v2/api-docs",
	// 					"/swagger-resources/configuration/security", 
	// 					"/swagger-resources", "/webjars/**",
	// 					"/testForgotPwd/**")
	// 				  .antMatchers(HttpMethod.OPTIONS, "/**");
	// }

}
