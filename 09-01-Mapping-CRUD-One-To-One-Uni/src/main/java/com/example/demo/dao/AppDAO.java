package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Instructor;

public interface AppDAO {
	
	public void save(Instructor instructor);
	
	public void saveAll(List<Instructor> instructorList);
	
	public Instructor findInstructorById(Integer id);
	
	public void deleteInstructorById(Integer id);

}
