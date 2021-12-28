package com.test.cargomanagementservice.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
//
//import com.ptjas.cgk.cargo.DAO.AuthDao;
//import com.ptjas.cgk.cargo.model.ApplicationUser;

@Service("userDetailService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {		
		if (username.equals("user")) {
			// return User.builder().username("rajat123").password("rajat123")
			// .authorities(Collections.emptyList()).build();
			return new UserIdentity(username,"pass","USER");
		} else {
			throw new UsernameNotFoundException(username);
		}
		
	}

}
