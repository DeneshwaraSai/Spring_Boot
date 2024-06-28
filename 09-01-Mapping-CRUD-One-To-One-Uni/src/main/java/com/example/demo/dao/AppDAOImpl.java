package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Instructor;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class AppDAOImpl implements AppDAO {
	
	EntityManager entityManager;
	
	@Autowired
	public AppDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	@Transactional
	public void save(Instructor instructor) {
		// TODO Auto-generated method stub
		entityManager.persist(instructor);
	}

	@Override
	@Transactional
	public void saveAll(List<Instructor> instructorList) {
		// TODO Auto-generated method stub
		for (Instructor instructor : instructorList) {
			entityManager.persist(instructor);
		}
	}

	@Override
	@Transactional
	public Instructor findInstructorById(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(Instructor.class, id);
	}

	@Override
	@Transactional
	public void deleteInstructorById(Integer id) {
		// TODO Auto-generated method stub
		Instructor instructor = entityManager.find(Instructor.class, id);
		
		entityManager.remove(instructor);
	}
}
