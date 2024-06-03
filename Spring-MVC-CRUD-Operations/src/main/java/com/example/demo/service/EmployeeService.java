package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(Integer id);

	public Employee save(Employee employee);
	
	public Employee update(Employee employee);
	
	public void deleteById(Integer employeeId);
}
