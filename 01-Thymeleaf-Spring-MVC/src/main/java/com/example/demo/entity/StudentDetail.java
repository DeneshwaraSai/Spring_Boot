package com.example.demo.entity;

import java.util.List;

public class StudentDetail {
	
	private String name;
	private String rollNo;
	private String standard;
	
	private String firstName;
	private String lastName;
	private String country;
	private String favouriteLanguage;
	
	private List<String> favouriteSystems;
	
	public StudentDetail() {
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getRollNo() {
		return rollNo;
	}
	
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	
	public String getStandard() {
		return standard;
	}
	
	public void setStandard(String standard) {
		this.standard = standard;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getFavouriteLanguage() {
		return favouriteLanguage;
	}

	public void setFavouriteLanguage(String favouriteLanguage) {
		this.favouriteLanguage = favouriteLanguage;
	}

	public List<String> getFavouriteSystems() {
		return favouriteSystems;
	}

	public void setFavouriteSystems(List<String> favouriteSystems) {
		this.favouriteSystems = favouriteSystems;
	}

	@Override
	public String toString() {
		return "StudentDetail [name=" + name + ", rollNo=" + rollNo + ", standard=" + standard + ", firstName="
				+ firstName + ", lastName=" + lastName + ", country=" + country + ", favouriteLanguage="
				+ favouriteLanguage + ", favouriteSystems=" + favouriteSystems + "]";
	}
}