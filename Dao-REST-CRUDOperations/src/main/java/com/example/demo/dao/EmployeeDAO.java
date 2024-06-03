package com.example.demo.dao;

import java.util.List;

import com.example.demo.Entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> findAll();
	
	public Employee findById(Integer employeeId);
	
	public void save(Employee employee);
	
	public void saveAll(List<Employee> employee);
	
	public void update(Employee employee);
	
	public void delete(Employee employee);
}
