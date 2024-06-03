package com.example.code.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDAOImpl implements StudentDAO {

	private EntityManager entityManager;

	// inject entity manager using constructor injection
	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void save(Student student) {
		// TODO Auto-generated method stub
		entityManager.persist(student);
	}

	@Override
	public Student findById(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		TypedQuery<Student> typedQuery = entityManager.createQuery("from Student ORDER BY lastName DESC", Student.class);
		List<Student> studentList = typedQuery.getResultList();
		return studentList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> findByLastName(String name) {
		// TODO Auto-generated method stub

		List<Student> result = entityManager.createQuery("FROM Student Where lastName LIKE CONCAT('%', :name, '%')", Student.class)
											.setParameter("name", name)					
											.getResultList();
		return result;
	}

	@Override
	@Transactional
	public void UpdateStudentById(Student student) {
		entityManager.merge(student);
	}

	@Override
	@Transactional
	public void nativeUpdateStudentById(Student student) {
		// TODO Auto-generated method stub

		int students = entityManager.createQuery("UPDATE Student SET lastName=:lastName where id=:studentId")
										.setParameter("lastName", student.getLastName())
										.setParameter("studentId", student.getId())
										.executeUpdate();

		System.out.println(students);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void deleteById(Integer studentId) {
		// TODO Auto-generated method stub
		
		Student student = entityManager.find(Student.class, studentId);
		 
		entityManager.remove(student);
	}

	@Override
	@Transactional
	public void nativeDeleteStudentById(Student student) {
		// TODO Auto-generated method stub

		try {
			entityManager.createQuery("DELETE FROM Student where ID=:studentId")
					.setParameter("studentId", student.getId())
					.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
	}
}
