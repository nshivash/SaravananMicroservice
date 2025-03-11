package com.usertask.User;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/jpa")
public class UserJpa {

	@Autowired
	private UserRepository userrepo;
	
	@GetMapping("/users")
	public List<Users_> getUsers(){
		return userrepo.findAll();
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<Users_> getUser(@PathVariable int id){
		Optional<Users_> user=userrepo.findById(id);
		
		if(!user.isPresent()) {
			throw new UserNotFoundException("id ="+id);
		}
		ResponseEntity<Users_> res=ResponseEntity.ok(user.get());
		return res;
	}
	
	@DeleteMapping("/users/{id}")
	public String deletesuser(@PathVariable int id){
		userrepo.deleteById(id);
		return "deleted user id="+id;
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> addUser(@RequestBody Users_ user){
		Users_ savedUser=userrepo.save(user);
		
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getUser_Id()).toUri();
		return ResponseEntity.created(location).build();
		//return ResponseEntity.ok(user.getUser_Name()+"user created");
	}
}
