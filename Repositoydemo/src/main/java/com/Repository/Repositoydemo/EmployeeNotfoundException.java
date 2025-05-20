package com.Repository.Repositoydemo;

@SuppressWarnings("serial")
public class EmployeeNotfoundException extends RuntimeException {
	
	public EmployeeNotfoundException(String message) {
		super(message);
	}
}
