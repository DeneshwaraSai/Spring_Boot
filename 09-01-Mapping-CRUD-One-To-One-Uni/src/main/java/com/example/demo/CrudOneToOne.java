package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.dao.AppDAO;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetail;

@SpringBootApplication
public class CrudOneToOne {

	public static void main(String[] args) {
		SpringApplication.run(CrudOneToOne.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			System.out.println("Hello World");
			saveInstructor(appDAO);
			saveAllInstructor(appDAO);
			
			findInstructorById(appDAO);
			
//			deleteInstructorById(appDAO);
		};
	}

	private void saveInstructor(AppDAO appDAO) {
		// TODO Auto-generated method stub
		Instructor instructor = new Instructor("Neil", "john", "john@gmail.com");
		InstructorDetail detail = new InstructorDetail("Neil John", "PC gaming");
		
		instructor.setInstructorDetail(detail);

		appDAO.save(instructor);
		
		System.out.println("Done!!!");
		System.out.println(instructor.toString());
	}
	
	private void saveAllInstructor(AppDAO appDAO) {
		
		Instructor instructor = new Instructor("William", "kane", "kane@gmail.com");
		InstructorDetail detail = new InstructorDetail("kane william", "Cricketer");
		
		instructor.setInstructorDetail(detail);
		
		Instructor instructor1 = new Instructor("root", "Joe", "root@gmail.com");
		InstructorDetail detail1 = new InstructorDetail("Joe root", "Batsmen");
		
		instructor1.setInstructorDetail(detail1);
		
		List<Instructor> instructorList = new ArrayList<Instructor>();
		instructorList.add(instructor);
		instructorList.add(instructor1);
		
		appDAO.saveAll(instructorList);
		
		System.out.println("Done!!!");
		System.out.println(instructorList.toString());
	}

	private void findInstructorById(AppDAO appDAO) {
		Instructor instructor = appDAO.findInstructorById(1);
		
		System.out.println("Done!!!");
		System.out.println(instructor.toString());
	}

	private void deleteInstructorById(AppDAO appDAO) {
		// TODO Auto-generated method stub
		
		appDAO.deleteInstructorById(2);
	}
}
