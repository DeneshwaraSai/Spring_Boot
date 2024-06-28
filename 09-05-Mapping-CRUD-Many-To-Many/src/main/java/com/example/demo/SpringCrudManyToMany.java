package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.dao.AppDAO;
import com.example.demo.entity.Course;
import com.example.demo.entity.Student;

@SpringBootApplication
public class SpringCrudManyToMany {

	public static void main(String[] args) {
		SpringApplication.run(SpringCrudManyToMany.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			System.out.println("Hello World");
			
//			createStudentsAndCourses(appDAO);
			
//			findCourseAndStudentByCourseId(appDAO);
			
//			findStudentAndCourseAndByStudentId(appDAO);
			
//			addMoreCoursesForStudent(appDAO);
			
//			deleteCourseById(appDAO);
			
			deleteStudentByStudentId(appDAO);
		};
	}

	private void createStudentsAndCourses(AppDAO appDAO) {
		// TODO Auto-generated method stub
		Course course = new Course("Learning HTML");
		
		course.addStudent(new Student("John", "Vivek", "vivek@gmail.com"));
		course.addStudent(new Student("susan", "mary", "mary@gmail.com"));
		
		appDAO.saveCourse(course);
		
		System.out.println(course.toString());
		System.out.println(course.getStudents().toString());
		System.out.println("DONE!!");
	}
	
	private void findCourseAndStudentByCourseId(AppDAO appDAO) {
		// TODO Auto-generated method stub
		Integer courseId = 20;
		Course course = appDAO.findCourseAndStudentByCourseId(courseId);
		
		System.out.println("Courses : " + course.toString());
		System.out.println("Courses-Student : " + course.getStudents().toString());	
	}
	
	private void findStudentAndCourseAndByStudentId(AppDAO appDAO) {
		// TODO Auto-generated method stub
		Integer studentId = 2;
		Student student = appDAO.findStudentAndCourseAndByStudentId(studentId);
		
		System.out.println("Student : " + student.toString());
		System.out.println("Student-Courses : " + student.getCourses().toString());		
	}
	
	private void addMoreCoursesForStudent(AppDAO appDAO) {
		// TODO Auto-generated method stub
		
		Integer studentId = 2;
		
		Student student = appDAO.findStudentAndCourseAndByStudentId(studentId);
		
		Course course1 = new Course("Introducton to Algorithms");
		Course course2 = new Course("Introducton to Machine Learning");
		
		student.addCourses(course1);
		student.addCourses(course2);
		
		appDAO.updateStudent(student);
		
		System.out.println("Student : " + student.toString());
		System.out.println("Student-Courses : " + student.getCourses().toString());
		
		System.out.println("Done !!!");
	}
	
	public void deleteCourseById(AppDAO appDAO) {
		Integer courseId = 21;
		
		appDAO.deleteCourseById(courseId);
		
		System.out.println("Done !!!");
		
	}
	
	private void deleteStudentByStudentId(AppDAO appDAO) {
		// TODO Auto-generated method stub
		Integer studentId = 2;
		
		appDAO.deleteStudentByStudentId(studentId);
		
		System.out.println("Done !!!");
	}
}
