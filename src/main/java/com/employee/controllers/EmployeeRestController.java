package com.employee.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entities.Employee;
import com.employee.repos.EmployeeRepository;

@RestController
public class EmployeeRestController {
	
	@Autowired
	EmployeeRepository repository;
	
	@GetMapping(value = "/employees")
	public List<Employee> getEmployees(){
		return repository.findAll();
	}
	
	@GetMapping(value = "/employee/{id}")
	public Employee getEmployee(@PathVariable("id") int id) {
		return repository.findById(id).get();
	}
	
	@PostMapping(value = "/employee")
	public Employee createEmployee(@RequestBody Employee employee) {
		return repository.save(employee);
	}
	
	@PutMapping(value = "/employee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return repository.save(employee);
	}
	
	@DeleteMapping(value = "/employee/{id}")
	public void deleteEmployee(@PathVariable("id") int id) {
		repository.deleteById(id);
	}

}
