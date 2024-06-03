package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Employee;
import com.example.demo.dao.EmployeeDAO;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;

	@Autowired 
	public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeDAO.findAll();
	}

	@Override
	public Employee findById(Integer employeeId) {
		// TODO Auto-generated method stub
		return employeeDAO.findById(employeeId);
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		employeeDAO.save(employee);
	}

	@Override
	@Transactional
	public void saveAll(List<Employee> employee) {
		// TODO Auto-generated method stub
		employeeDAO.saveAll(employee);
	}

	@Override
	@Transactional
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		employeeDAO.update(employee);
	}

	@Override
	@Transactional
	public void delete(Integer employeeId) {
		// TODO Auto-generated method stub
		Employee employee = employeeDAO.findById(employeeId);
		if(employee == null) {
			throw new RuntimeException("Employee Id is not found : " + employeeId);
		}
		employeeDAO.delete(employee);
	}
}
