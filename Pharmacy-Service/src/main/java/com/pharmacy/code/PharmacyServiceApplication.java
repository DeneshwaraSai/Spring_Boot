package com.pharmacy.code;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.pharmacy.code.entity.Inventory;
import com.pharmacy.code.repository.InventoryRepository;
import com.pharmacy.code.service.CodeValueService;
import com.pharmacy.code.service.InventoryService;

import jakarta.persistence.EntityManager;

@SpringBootApplication
public class PharmacyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PharmacyServiceApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(CodeValueService codeValueService, EntityManager entityManager) {
		return runner -> {
			System.out.println("Hello World");
//			getCodeValues(codeValueService);
//			checkSupplier(entityManager);
		};
	}
	
	 public void getCodeValues(CodeValueService codeValueService) {
		 codeValueService.findAllCodeValues();
	 }
	 
	 public void checkSupplier(EntityManager entityManager) {
		 String value = "CVS";
			Object flag = entityManager.createQuery("select count(*) from Supplier Where code=:code") 
					   .setParameter("code", value)
					   .getSingleResult();
			System.out.println(flag);
			System.out.println( (flag.toString().equals("1")) ? true: false);
	 }
}