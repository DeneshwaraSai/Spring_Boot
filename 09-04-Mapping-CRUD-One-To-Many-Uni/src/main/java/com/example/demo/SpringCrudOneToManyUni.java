package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.dao.AppDAO;
import com.example.demo.entity.Course;
import com.example.demo.entity.Review;

@SpringBootApplication
public class SpringCrudOneToManyUni {

	public static void main(String[] args) {
		SpringApplication.run(SpringCrudOneToManyUni.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			
			System.out.println("Hello World");
			
//			createCourseAndReview(appDAO);
			
//			findCourseAndReviewByCourseId(appDAO);
			
			deleteCourseById(appDAO);
		};
	}

	private void createCourseAndReview(AppDAO appDAO) {
		// TODO Auto-generated method stub
		Course course = new Course("Batman - Its a book");

		course.addReview(new Review("Its a nice book"));
		course.addReview(new Review("Its worthy buying it"));
		course.addReview(new Review("Good one till now"));
		
		appDAO.saveCourse(course);
		System.out.println("Saved Successfully!");
		System.out.println(course.toString());
	}
	
	private void findCourseAndReviewByCourseId(AppDAO appDAO) {
		Course course = appDAO.findCourseAndReviewByCourseId(6);
		System.out.println("Course : " + course.toString());
		System.out.println("Reviews : " + course.getReviews().toString());
		System.out.println("Done !!");
	}
	
	private void deleteCourseById(AppDAO appDAO) {
		
		appDAO.deleteCourseById(6);
		
		System.out.println("Deleted!!");
	}

}
