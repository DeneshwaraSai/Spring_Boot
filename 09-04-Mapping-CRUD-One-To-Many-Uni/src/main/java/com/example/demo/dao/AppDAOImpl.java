package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetail;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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
		
		for (Course course : instructor.getCourses()) {
			course.setInstructor(null);
		}
		
		entityManager.remove(instructor);
	}

	@Override
	public InstructorDetail findInstructorDetailById(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(InstructorDetail.class, id);
	}

	@Override
	@Transactional
	public void deleteInstructorDetailById(Integer id) {
		// TODO Auto-generated method stub
		InstructorDetail detail = entityManager.find(InstructorDetail.class, id);
		
		detail.getInstructor().setInstructorDetail(null);
		
		entityManager.remove(detail);
	}

	@Override
	public List<Course> findCoursesByInstructorId(Integer id) {
		// TODO Auto-generated method stub
		
		TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id = :instructorId",Course.class)
								.setParameter("instructorId", id);
		
		List<Course> courses = query.getResultList();
		return courses;
	}

	@Override
	public Instructor findInstructorByIdAndJoinFetch(Integer id) {
		// TODO Auto-generated method stub
		
		TypedQuery<Instructor> query = entityManager.createQuery("select i from Instructor i "
															+ "JOIN FETCH i.courses "
															+ "JOIN FETCH i.instructorDetail "
															+ "where i.id = :instructorId", Instructor.class);
		query.setParameter("instructorId", id);
		Instructor instructor = query.getSingleResult();
		return instructor;
	}

	@Override
	@Transactional
	public void updateInstructor(Instructor instructor) {
		// TODO Auto-generated method stub
		entityManager.merge(instructor);
	}

	@Override
	@Transactional
	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
		entityManager.merge(course);
	}

	@Override
	public Course findCourseById(Integer courseId) {
		// TODO Auto-generated method stub
		return entityManager.find(Course.class, courseId);
	}

	@Override
	@Transactional
	public void deleteCourseById(Integer courseId) {
		// TODO Auto-generated method stub
		Course course = entityManager.find(Course.class, courseId);
		entityManager.remove(course);
	}

	@Override
	@Transactional
	public void saveCourse(Course course) {
		// TODO Auto-generated method stub
		entityManager.persist(course);
	}

	@Override
	public Course findCourseAndReviewByCourseId(Integer courseId) {
		// TODO Auto-generated method stub
		Course course = (Course) entityManager.createQuery("select c from Course c "
				+ "JOIN FETCH c.reviews "
				+ "where c.id = :courseId")
			.setParameter("courseId", courseId)
			.getSingleResult();
		
		return course;
	}
}
