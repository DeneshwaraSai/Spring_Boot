package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetail;

public interface AppDAO {
	
	public void save(Instructor instructor);
	
	public void saveAll(List<Instructor> instructorList);
	
	public Instructor findInstructorById(Integer id);
	
	public void deleteInstructorById(Integer id);
	
	public InstructorDetail findInstructorDetailById(Integer id);
	
	public void deleteInstructorDetailById(Integer id);
}
