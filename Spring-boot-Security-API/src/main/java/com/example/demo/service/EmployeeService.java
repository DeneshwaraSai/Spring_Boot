package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findById(Integer employeeId);
	
	public void save(Employee employee);
	
	public void saveAll(List<Employee> employee);
	
	public void update(Employee employee);
	
	public void delete(Integer employeeId);
}
