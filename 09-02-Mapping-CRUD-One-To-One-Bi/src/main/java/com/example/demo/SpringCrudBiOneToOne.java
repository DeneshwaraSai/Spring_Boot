package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.dao.AppDAO;
import com.example.demo.entity.InstructorDetail;

@SpringBootApplication
public class SpringCrudBiOneToOne {

	public static void main(String[] args) {
		SpringApplication.run(SpringCrudBiOneToOne.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			System.out.println("Hello world");
			
//			findInstructorDetailById(appDAO);
			deleteInstructorDetailById(appDAO);
		};
	}

	private void findInstructorDetailById(AppDAO appDAO) {
		// TODO Auto-generated method stub
		InstructorDetail detail = appDAO.findInstructorDetailById(5);
		System.out.println(detail.toString());
	}
	
	private void deleteInstructorDetailById(AppDAO appDAO) {
		appDAO.deleteInstructorDetailById(6);
		System.out.println("Done !!!");
	}
}
