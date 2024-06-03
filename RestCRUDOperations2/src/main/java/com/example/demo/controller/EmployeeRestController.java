package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeRestController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping(path = "/employees/all") 
	public List<Employee> findAllEmployees() {
		return employeeService.findAll();
	}

	@GetMapping(path = "/employees/{employeeId}") 
	public Employee findEmployeeById(@PathVariable("employeeId") Integer employeeId) {
		return employeeService.findById(employeeId);
	}

	@PostMapping(path = "/employees") 
	public Employee save(@RequestBody Employee employee) {
		employeeService.save(employee);
		return employee;
	}

	@PutMapping(path = "/employees") 
	public Employee update(@RequestBody Employee employee) {
		employeeService.update(employee);
		return employee;
	}
	
	@DeleteMapping(path = "/employees/{emloyeeId}")
	public void deleteById(@PathVariable(name = "emloyeeId") Integer emloyeeId) {
		employeeService.delete(emloyeeId);
	}
}
