package com.example.demo.validation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {
	
	private String courseCodePrefix;
	
	@Override
	public void initialize(CourseCode theCourseCode) {
		this.courseCodePrefix = theCourseCode.value();
	}
	
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		
		if(theCode != null) {
			if(theCode.startsWith(this.courseCodePrefix)) {
				return true;
			} 
		}
		return false;
	}

 
	
	 

}
