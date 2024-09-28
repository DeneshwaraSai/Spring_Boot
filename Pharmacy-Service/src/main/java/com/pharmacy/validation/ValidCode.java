package com.pharmacy.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = CommonValidCode.class)
@Target({ ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCode {
	public String value() ;

	public String message();

	// define default groups
	public Class<?>[] groups() default {};

	// define default payload
	public Class<? extends Payload>[] payload() default {};
}
