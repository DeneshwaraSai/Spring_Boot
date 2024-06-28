package com.example.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.dao.AppDAO;
import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetail;

@SpringBootApplication
public class SpringCrudOneToMany {

	public static void main(String[] args) {
		SpringApplication.run(SpringCrudOneToMany.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			System.out.println("Hello World");
			 
//			createInstructorWithCourse(appDAO); 
			
//			findInstructorWithCourse(appDAO); 
			
//			findCoursesByInstructorId(appDAO);
			
//			findInstructorByIdAndJoinFetch(appDAO);
			
//			updateInstructor(appDAO);
			
//			updateCourse(appDAO);
			
//			deleteInstructor(appDAO);
			
			deleteCourseById(appDAO);
		};
	}
	
	public void createInstructorWithCourse(AppDAO appDAO) {
		
		Instructor instructor = new Instructor("William", "kane", "kane@gmail.com");
		InstructorDetail detail = new InstructorDetail("william kane", "Video Games");
		
		instructor.setInstructorDetail(detail);
		
		 Course course1 = new Course("Hyper Text Markup Language - HTML.");
		 Course course2 = new Course("Cascading Style Sheets - CSS.");
		 
		 instructor.add(course1);
		 instructor.add(course2);
		 
		 System.out.println("Saving Instructor : " + instructor.toString());
		 System.out.println("Savng courses : " + instructor.getCourses().toString());
		 
		 appDAO.save(instructor);
		 
		 System.out.println("Done !!!");
	}
	
	public void findInstructorWithCourse(AppDAO appDAO) {
		
		Instructor instructor = appDAO.findInstructorById(9);
		
		System.out.println("Instructor Data : " + instructor.toString());
		System.out.println("Instructor-Courses Data : " + instructor.getCourses().toString());
	}
	
	public void findCoursesByInstructorId(AppDAO appDAO) {
		Integer instructorId = 9;
		
		Instructor instructor = appDAO.findInstructorById(instructorId);
		
		List<Course> courses = appDAO.findCoursesByInstructorId(instructorId);
		
		instructor.setCourses(courses);
		
		System.out.println("Instructor is : " + instructor.toString());
		System.out.println("Course are : "+ courses.toString());
		
		System.out.println("Done !!!");
	}
	
	public void findInstructorByIdAndJoinFetch(AppDAO appDAO) {
		Integer instructorId = 9;
		
		Instructor instructor = appDAO.findInstructorByIdAndJoinFetch(instructorId);
		
		System.out.println("Instructor is : " + instructor.toString());
		
		System.out.println("Course is : " + instructor.getCourses().toString());
	}
	
	public void updateInstructor(AppDAO appDAO) {
		
		Integer instructorId = 9;
		Instructor instructor = appDAO.findInstructorById(instructorId);
		
		instructor.setLastName("Engineer");
		appDAO.updateInstructor(instructor);
		
		System.out.println("Instructor is : " + instructor.toString());
	}
	
	public void updateCourse(AppDAO appDAO) {
		Integer courseId = 2;
		
		Course course = appDAO.findCourseById(courseId);
		
		course.setTitle("javaScript is a scripting language.");
		
		appDAO.updateCourse(course);
		
		System.out.println("Updated course : " + course.toString());
	}
	
	public void deleteInstructor(AppDAO appDAO) {
		Integer instructorId = 10;
		
		appDAO.deleteInstructorById(instructorId);
		System.out.println("Instructor id : " + instructorId + "! Delete.");
	}
	
	public void deleteCourseById(AppDAO appDAO) {
		Integer courseId = 1;
		
		appDAO.deleteCourseById(courseId);
		System.out.println("Done !!");
	}
}
