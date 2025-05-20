package com.Repository.Repositoydemo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository emprepo;
	
	public List<Employee> getallEmployees(){
		return emprepo.findAll();
	}

	public ResponseEntity<Employee> getEmployeById(int id) {
		Optional<Employee> emp=emprepo.findById(id);
		if(emp.isPresent()) {
			ResponseEntity<Employee> empres=ResponseEntity.ok(emp.get());
			return empres;
		}else {
			throw new EmployeeNotfoundException("id "+id);
		}
	}
	
	public ResponseEntity<Object> addEmployee(Employee emp){
		Employee saveemp=emprepo.save(emp);
		return ResponseEntity.ok(saveemp.getEmpName()+"  created");
	}
}
