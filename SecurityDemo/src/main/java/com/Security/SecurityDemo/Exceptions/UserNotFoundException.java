package com.Security.SecurityDemo.Exceptions;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String message) {
		super(message);
	}

}
