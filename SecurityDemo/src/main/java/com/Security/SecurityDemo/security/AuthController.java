package com.Security.SecurityDemo.security;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Security.SecurityDemo.Entity.UserEntity;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authManager;
	@Autowired
	private JwtUtils jwtutil;
	
	@PostMapping("/login")
	public ResponseEntity<Map<String, String>> login(@RequestBody UserEntity user) {
		try {
			Authentication authenticate = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
			UserDetails principal = (UserDetails)authenticate.getPrincipal();
			String token = jwtutil.generateToken(principal);
			return ResponseEntity.ok(Map.of("token",token));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error","Invalid token"));
		}
	}
}
