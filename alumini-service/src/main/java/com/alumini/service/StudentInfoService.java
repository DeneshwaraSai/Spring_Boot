package com.alumini.service;

import java.util.List;
import java.util.Optional;

import com.alumini.entity.StudentInfo;

public interface StudentInfoService {

	public StudentInfo createStudentInfo(StudentInfo studentInfo);
	
	public StudentInfo updateStudentInfo(StudentInfo studentInfo, Integer id);

	public Optional<StudentInfo> findById(Integer id);
	
	public void deleteById(Integer id);
	
	public List<StudentInfo> saveImportedStudentInfo(List<Object> studentInfoObjects);
}
