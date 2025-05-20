package com.Security.SecurityDemo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Security.SecurityDemo.Entity.UserEntity;
import com.Security.SecurityDemo.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userrepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Optional<UserEntity> getUser(long id) {
		Optional<UserEntity> byId = userrepo.findById(id);
		return byId;
	}
	public void addUser(UserEntity user) {
		String password=passwordEncoder.encode(user.getPassword());
		user.setPassword(password);
		userrepo.save(user);
	}

}
