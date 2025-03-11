package com.usertask.User;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public String handleUserException(UserNotFoundException e) {
		return e.getMessage()+" handled";
	}
	@ExceptionHandler(IdNotFoundException.class)
	public String handleIdException(IdNotFoundException e) {
		return e.getMessage()+" handled" ;
	}
}
