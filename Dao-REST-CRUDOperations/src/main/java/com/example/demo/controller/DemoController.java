package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Student;
import com.example.demo.Exception.StudentErrorResponse;
import com.example.demo.Exception.StudentNotFoundException;

@RestController
public class DemoController {

	@GetMapping("/test")
	public String testService() {
		return "Hello World";	
	}

	@GetMapping("/student/all")
	public List<Student> getAllStudents() {
		return setStudents();
	}

	@GetMapping("/student/{studentId}")
	public Student getStudentById(@PathVariable(name = "studentId") Integer studentId) {
		System.out.println(studentId);
		
		
		List<Student> studentList = setStudents();
		
		if (studentId < 0 || studentId >= studentList.size()) {
			 throw new StudentNotFoundException("Student id is not found - " + studentId);
		}
		
		return studentList.get(studentId);	
	}

	public List<Student> setStudents() {
		List<Student> studentList = new ArrayList<Student>();

		studentList.add(new Student("Dineshwara","Sai"));
		studentList.add(new Student("Ab","John"));
		studentList.add(new Student("Veer","Jai"));

		return studentList;
	}
}
