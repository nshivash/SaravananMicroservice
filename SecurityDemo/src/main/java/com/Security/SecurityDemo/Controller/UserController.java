package com.Security.SecurityDemo.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Security.SecurityDemo.Entity.UserEntity;
import com.Security.SecurityDemo.Service.UserService;

@RestController
@RequestMapping("/home")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public String hello() {
		return "hello world";
	}
	@GetMapping("/user/{id}")
	public Optional<UserEntity> getUser(@PathVariable int id) {
		return service.getUser(id);
	}
	@PostMapping("/user")
	public ResponseEntity<String> addUser(@RequestBody UserEntity user){
		service.addUser(user);
		return new ResponseEntity<>("Added user Succesfully",HttpStatus.ACCEPTED);
	}
}