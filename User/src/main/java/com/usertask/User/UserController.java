//package com.usertask.User;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/UserApi")
//public class UserController {
//	
//	@Autowired
//	UserService userservice;
//	
//	@PostMapping("/User")
//	public ResponseEntity<Object> addUser(@RequestBody Users_ user){
//		return userservice.addUser(user);
//	}
//	
//	@GetMapping("/User")
//	public List<Users_> getUser(){
//		return userservice.getUser();
//	}
//	
//	@GetMapping("/User/{id})")
//	public Users_ getUserbyId(@PathVariable int id) {
//		return userservice.getUserbyId(id);
//	}
//	
//	@DeleteMapping("/User/{id}")
//	public ResponseEntity<Object> deleteUser(@PathVariable int id) {
//		return userservice.deleteUser(id);
//	}
//	
//	@PutMapping("/User/{id}")
//	public ResponseEntity<Object> updateUser(@RequestBody Users_ user,@PathVariable int id){
//		userservice.updateUser(user,id);
//		return new ResponseEntity<Object>(user,HttpStatus.ACCEPTED);
//	}
//}
