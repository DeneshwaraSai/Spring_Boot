package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetail;

public interface AppDAO {
	
	public void save(Instructor instructor);
	
	public void saveAll(List<Instructor> instructorList);
	
	public Instructor findInstructorById(Integer id);
	
	public void deleteInstructorById(Integer id);
	
	public InstructorDetail findInstructorDetailById(Integer id);
	
	public void deleteInstructorDetailById(Integer id);
	
	public List<Course> findCoursesByInstructorId(Integer id);
	
	public Instructor findInstructorByIdAndJoinFetch(Integer id);
	
	public void updateInstructor(Instructor instructor);
	
	public void updateCourse(Course course);
	
	public Course findCourseById(Integer courseId);
	
	public void deleteCourseById(Integer courseId);
	
}
