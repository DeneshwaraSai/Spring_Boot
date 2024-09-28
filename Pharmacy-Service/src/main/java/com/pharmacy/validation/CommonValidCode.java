package com.pharmacy.validation;

import org.springframework.beans.factory.annotation.Autowired;

import com.pharmacy.code.service.SupplierService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CommonValidCode implements ConstraintValidator<ValidCode, String> {

	private String code;

	@Autowired
	EntityManager entityManager;

//	public CommonValidCode() {}
//
//	@Autowired
//	public CommonValidCode(EntityManager entityManager) {
//		this.entityManager = entityManager;
//	}

	@Override
	public void initialize(ValidCode code) {
		this.code = code.value();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		// TODO Auto-generated method stub
		System.out.println("Code : " + this.code);
		System.out.println("Value : " + value);
		if (code.equals("SUPPLIER")) {
			Object flag = this.entityManager.createQuery("select count(*) from Supplier Where code=:code") 
					.setParameter("code", value)
					.getSingleResult();

			return (flag.toString().equals("1"));
		}
		return true;
	}

}
