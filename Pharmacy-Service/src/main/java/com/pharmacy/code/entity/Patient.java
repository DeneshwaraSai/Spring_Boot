package com.pharmacy.code.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "PATIENT")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name =  "ID")
	private Integer id;

	@Column(name="FIRST_NAME")
	@NotBlank(message = "First name cannot be empty or null.")
	@Size(min = 1,max = 20 , message = "The lenght of first name should not exceed 20.")
	private String firstName;

	@Column(name="LAST_NAME")
	private String lastName;

	@Column(name="UHID")
	@NotNull(message = "uhid cannot be null.")
	private Integer uhid;

	@Column(name = "DATE_OF_BIRTH")
	@NotNull(message = "The date of birth cannot be empty")
	private Date dateOfBirth;

	@Column(name="GENDER", length = 1)
	@Size(min = 1, max = 1, message = "The lenght of gender should be 1.")
	@NotBlank(message = "Gender cannot be empty or null.")
	private String gender;

	@Column(name="EMAIL")
	@Size(max = 40 , message = "The lenght of email should not exceed 40.")
	private String email;

	@Column(name= "PHONE_NUMBER") 
	@NotBlank(message = "Phone number cannot be empty or null.")
	@Size(min = 1, max = 10, message = "The lenght of phone number should be 10.")
	private String phoneNumber;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getUhid() {
		return uhid;
	}

	public void setUhid(Integer uhid) {
		this.uhid = uhid;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth="
				+ dateOfBirth + ", gender=" + gender + ", email=" + email + ", uhid=" + uhid + ", phoneNumber="
				+ phoneNumber + "]";
	}
}
