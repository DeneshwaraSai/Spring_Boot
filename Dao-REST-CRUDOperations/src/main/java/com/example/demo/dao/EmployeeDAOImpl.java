package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository 
public class EmployeeDAOImpl implements EmployeeDAO {
	
	public EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOImpl (EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		TypedQuery<Employee> employee = entityManager.createQuery("from Employee", Employee.class);
		return employee.getResultList(); 	
	}

	@Override
	public Employee findById(Integer employeeId) {
		// TODO Auto-generated method stub
		
//		TypedQuery<Employee> employeeT = entityManager.createQuery("from Employee where ID = :employeeId", Employee.class);
//		
//		Employee employee = employeeT.setParameter("employeeId", employeeId)
//									 .getSingleResult();
		
		return entityManager.find(Employee.class, employeeId);
	}

	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		entityManager.persist(employee);
	}

	@Override
	public void saveAll(List<Employee> employeeList) {
		// TODO Auto-generated method stub
		entityManager.persist(employeeList);
	}

	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		entityManager.merge(employee);
	}

	@Override
	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		entityManager.remove(employee);
	}
}
