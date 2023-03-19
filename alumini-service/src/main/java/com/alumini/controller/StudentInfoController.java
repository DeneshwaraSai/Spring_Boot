package com.alumini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alumini.entity.StudentInfo;
import com.alumini.service.StudentInfoService;

@CrossOrigin(origins = {"http://localhost:4200/"})
@RestController
public class StudentInfoController {

	@Autowired
	StudentInfoService studentInfoService;

	@PostMapping("/student/create")
	public StudentInfo create(@RequestBody StudentInfo studentInfo) {
		StudentInfo info = null;
		try {
			info = studentInfoService.createStudentInfo(studentInfo);
			return info;
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@PutMapping("/student/update/{studentId}")
	public StudentInfo updateStudentInfo(
			@PathVariable(name = "studentId", required = true) Integer id,  
			@RequestBody StudentInfo studentInfo) {
		try {
			StudentInfo resInfo = studentInfoService.updateStudentInfo(studentInfo, id);
			return resInfo;
		} catch(Exception e) {
			throw e;
		}
	}

	@GetMapping(name = "/student/get/{studentId}")
	public StudentInfo getStudentInfoById(@PathVariable(name = "studentId") Integer studentId) {
		try {
			StudentInfo studentInfo = studentInfoService.findById(studentId).get();
			return studentInfo;
		} catch(Exception e) {
			throw e;
		}
	}
	
	@DeleteMapping("/student/{studentId}")
	public void deleteByStudentId(@PathVariable (name = "studentId") Integer id) {
		try {
			studentInfoService.deleteById(id);
		} catch (Exception e) {
			
		}
	}
	
	@PostMapping("/student/import/save")
	public List<StudentInfo> saveImportedData(@RequestBody List<Object> objects) {
		List<StudentInfo> results = studentInfoService.saveImportedStudentInfo(objects);
		System.out.println("Imported data saved successfully.");
		return results;
	}
}
