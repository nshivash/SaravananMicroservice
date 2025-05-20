package com.Repository.Repositoydemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private EmployeeService empservice;
	
	@GetMapping("/employees")
	public List<Employee> getallEmployees(){
		return empservice.getallEmployees();
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeebyId(@PathVariable int id) {
		return empservice.getEmployeById(id);
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Object> addEmployee(@Validated @RequestBody Employee emp){
		return empservice.addEmployee(emp);
	}
}
