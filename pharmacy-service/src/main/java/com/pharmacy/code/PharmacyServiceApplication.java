package com.pharmacy.code;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.pharmacy.code.service.CodeValueService;

@SpringBootApplication
public class PharmacyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PharmacyServiceApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(CodeValueService codeValueService) {
		return runner -> {
			System.out.println("Hello World");
//			getCodeValues(codeValueService);
		};
	}
	
	 public void getCodeValues(CodeValueService codeValueService) {
		 codeValueService.findAllCodeValues();
	 }
}
