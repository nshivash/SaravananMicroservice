package com.usertask.User;

@SuppressWarnings("serial")
public class IdNotFoundException extends RuntimeException {

	public IdNotFoundException(String message) {
		super(message+" Not found");
	}	
	
}
