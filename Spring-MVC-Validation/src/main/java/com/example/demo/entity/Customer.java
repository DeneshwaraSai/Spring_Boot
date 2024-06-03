package com.example.demo.entity;

import com.example.demo.validation.CourseCode;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Customer {

	@Size(max = 15, message = "Max size should be 15 for firstname")
	private String firstName;

	@NotNull(message = "last Name cannot be empty.")
	@Size(min = 1, message = "Min size should be 1 for lastname")
	private String lastName;

	@NotNull(message = "The value cannot be null.")
	@Min(value = 0, message = "The value should be greater than or equal to zero.")
	@Max(value = 10, message = "The value should not exceed 10.")
	private Integer freePasses = 0;

	@NotNull(message = "Postal code cannot be null.")
	@Pattern(regexp = "^[a-zA-Z0-9]{5}", message="Only 5 chars/digits.")
	private String postalCode;

	@CourseCode(value = "CS", message = "The course code should start with 'CS'.")
	private String courseCode;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", freePasses=" + freePasses
				+ ", postalCode=" + postalCode + ", courseCode=" + courseCode + "]";
	}
}
