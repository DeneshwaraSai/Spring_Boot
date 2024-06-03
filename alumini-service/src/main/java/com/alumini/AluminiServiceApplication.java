package com.alumini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = {"http://localhost:4200/"})
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class, scanBasePackages = {"com.alumini"})
@ComponentScan(basePackages = {"com.alumini"})
@EnableJpaRepositories(basePackages = {"com.alumini"})
public class AluminiServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AluminiServiceApplication.class, args);
		System.out.println("Hii Welcome Alumini App.");
	}

}
