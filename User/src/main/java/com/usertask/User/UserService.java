//package com.usertask.User;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserService {
//
//	static List<Users_> userlist=new ArrayList<>();
//	
//	static {
//		userlist.add(new Users_(1,"Ganesh"));
//		userlist.add(new Users_(2,"sures"));
//		userlist.add(new Users_(3,"Robo"));
//		userlist.add(new Users_(4,"rubesh"));
//	}
//	//set new User
//	ResponseEntity<Object> addUser(Users_ user){
//		if(user.getUser_Name()==null) {
//			throw new IdNotFoundException("id = "+user.getUser_Id());
//		}
//		userlist.add(user);
//		return new ResponseEntity<Object>(user,HttpStatus.ACCEPTED);
//	}
//	
//	//get all User
//	List<Users_> getUser(){
//		return userlist;
//	}
//	
//	//get user by ID
//	Users_ getUserbyId(int id) {
//		for(Users_ usr:userlist) {
//			if(usr.getUser_Id()==id) {
//				return usr;
//			}
//		}
//		throw new UserNotFoundException("id "+id);
//	}
//	
//	//Delete User by id
//	ResponseEntity<Object> deleteUser(int id) {
//		boolean removed=userlist.removeIf(user->user.getUser_Id()==id);
//		return removed?new ResponseEntity<Object>(HttpStatus.ACCEPTED):new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
//	}
//
//	public void updateUser(Users_ user, int id) {	
//		for(Users_ usr:userlist) {
//			if(usr.getUser_Id()==id) {
//				if(user.getUser_Name()!=null) {
//					usr.setUser_Name(user.getUser_Name());
//				}
//			}	
//		}
//	}
//}