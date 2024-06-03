package com.alumini.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@MappedSuperclass
public class Person {

	@Column(name = "FIRST_NAME",  length=50)
	@NotNull(message = "The first name cannot be empty.")
	@Pattern(regexp = "[a-zA-Z. ]*\\.?", message = "Invalid first name pattern")
	@Size(min = 1, max=50, message = "The length of first name is more than 50")
	private String firstName;
	
	@Column(name = "LAST_NAME", nullable = false, length=50)
	@NotNull(message = "The last name cannot be empty.")
	@Pattern(regexp = "[a-zA-Z. ]*\\.?", message = "Invalid last name pattern")
	@Size(min = 1, max=50, message = "The length of last name is more than 50")
	private String lastName;
	
	@Column(name = "MIDDLE_NAME", nullable = true, length=50)
	@Pattern(regexp = "[a-zA-Z. ]*\\.?", message = "Invalid middle name pattern")
	@Size(max=50, message = "The length of middle name is more than 50")
	private String middleName;
	
	@Column(name = "UHID", nullable = false)
	private Long uhid;
	
	@Column(name = "GENDER", nullable = false, length = 1)
	@NotEmpty(message = "The gender cannot be null")
	@NotEmpty(message = "The gender cannot be empty")
	private String gender;

	@Column(name = "BIRTH_DATE", nullable = false)
	@NotNull(message = "The Date of birth cannot be empty")
	private Date birthDate;
	
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
	
	public String getMiddleName() {
		return middleName;
	}
	
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	public Long getUhid() {
		return uhid;
	}
	
	public void setUhid(Long uhid) {
		this.uhid = uhid;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", middleName=" + middleName + ", uhid="
				+ uhid + ", gender=" + gender + ", birthDate=" + birthDate + "]";
	}
}
