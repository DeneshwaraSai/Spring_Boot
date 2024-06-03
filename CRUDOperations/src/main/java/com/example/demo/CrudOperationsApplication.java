package com.example.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.example.code.dao.StudentDAO;
import com.example.demo.entity.Student;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.code.dao")
public class CrudOperationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudOperationsApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner ->{
			System.out.println("Hello World.");
			createStudent(studentDAO);
			multipleStudents(studentDAO);
			
//			readByStudentId(studentDAO);
//			getAllStudents(studentDAO);
//			findByLastName(studentDAO);
//			
//			updateStudent(studentDAO);
//			nativeUpdateStudentById(studentDAO);
//			
//			deleteById(studentDAO);
//			nativeDeleteById(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		System.out.println("Creating objects for student : ");
		Student student = new Student("Deneshwara Sai", "Ila", "email@gmail.com");

		studentDAO.save(student);
		System.out.println("Saving into DB .....");

		System.out.println("The saved student id is : " + student.getId());
	}
	
	public void multipleStudents(StudentDAO studentDAO) {
		
		System.out.println("Creating 3 student objects ...");
		Student tempstudent1 = new Student("John", "Doe", "john@luv2code.com"); ;
		Student tempstudent2 = new Student("Mary", "Public", "mary@luv2code.com");
		Student tempstudent3 = new Student ("Bonita",  "ARRLebum", "bonita@luv2code.com");
		
		System.out.println("Saving into DB .....");
		studentDAO.save(tempstudent1);
		studentDAO.save(tempstudent2);
		studentDAO.save(tempstudent3);
	}
	
	private void readByStudentId(StudentDAO studentDAO) {
		// TODO Auto-generated method stub

		Student student = new Student("Name", "Name", "namename@gmail.com");
		studentDAO.save(student);
		
		Student result = studentDAO.findById(student.getId());
		
		System.out.println(result.toString());
	}
	
	private void getAllStudents(StudentDAO studentDAO) {
		// TODO Auto-generated method stub	
		List<Student> studentList = studentDAO.findAll();
		display(studentList);
	}
	
	private void display (List<Student> studentList) {
		for (Student list : studentList) {
			System.out.println(list.toString());
		}
	}
	
	private void findByLastName(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		
		List<Student> studentList = studentDAO.findByLastName("me");
		display(studentList);
	}
	
	private void updateStudent(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		Student student = studentDAO.findById(3005);
		student.setFirstName("Johnson");
		
		studentDAO.UpdateStudentById(student);
		
		System.out.println(student.toString());
	}
	
	private void nativeUpdateStudentById(StudentDAO studentDAO) {
		Student student = studentDAO.findById(3005);
		student.setEmail("johnson@gmail.com");
			
		studentDAO.nativeUpdateStudentById(student);
		System.out.println(student.toString());
	}
	

	private void deleteById(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		studentDAO.deleteById(3003);
		
		System.out.println("EM: DELETED BY ID 3003");
	}
	
	private void nativeDeleteById(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		Student student = studentDAO.findById(3004);
		studentDAO.nativeDeleteStudentById(student);
		
		System.out.println("Native EM: DELETED BY ID 3004");
	}
}
