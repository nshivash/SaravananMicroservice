package com.Security.SecurityDemo.Config;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.Security.SecurityDemo.Entity.UserEntity;
import com.Security.SecurityDemo.Exceptions.UserNotFoundException;
import com.Security.SecurityDemo.Repository.UserRepository;

@Component
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	UserRepository userrepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userdetail = userrepo.findByUsername(username)
				.orElseThrow(()->new UserNotFoundException(username+" username not found"));
		return new User(userdetail.getUsername(),
				userdetail.getPassword(),
				Collections.singleton(new SimpleGrantedAuthority("ROLE_OFFICER"))
				);
	}

}
