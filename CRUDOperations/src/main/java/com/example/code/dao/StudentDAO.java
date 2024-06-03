package com.example.code.dao;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentDAO {
	
	public void save(Student student);
	
	public Student findById(Integer id);
	
	public List<Student> findAll();
	
	public List<Student> findByLastName(String lastName);
	
	public void UpdateStudentById(Student student);
	
	public void nativeUpdateStudentById(Student student);
	
	public void deleteById(Integer studentId);
	
	public void nativeDeleteStudentById(Student student);
	
}
