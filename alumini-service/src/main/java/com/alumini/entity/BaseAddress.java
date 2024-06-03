package com.alumini.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MappedSuperclass
public class BaseAddress {

	@Column(name = "TYPE", length = 1)
	@NotNull(message = "The Type cannot be null")
	@NotEmpty(message = "The Type cannot be empty")
	@Size(min = 1, max = 1, message = "The length of type is more than 1")
	private String type;
	
	@Column(name = "LINE_ONE")
	@NotNull(message = "The Line one cannot be null")
	@NotEmpty(message = "The Line one cannot be empty")
	@Size(max = 40,  message = "The length of line one is more than 40")
	private String lineOne;
	
	@Column(name = "LINE_TWO")
	@Size(max = 40,  message = "The length of line two is more than 40")
	private String lineTwo;
	
	@Column(name = "LINE_THREE")
	@Size(max = 40,  message = "The length of line three is more than 40")
	private String lineThree;
	
	@Column(name = "CITY")
	@NotNull(message = "The city cannot be null")
	@NotEmpty(message = "The city cannot be empty")
	@Size(max = 25,  message = "The length of city is more than 25")
	private String city;
	
	@Column(name = "COUNTRY")
	@NotNull(message = "The country cannot be null")
	@NotEmpty(message = "The country cannot be empty")
	@Size(max = 25,  message = "The length of country is more than 25")
	private String country;
	
	@Column(name = "STATE")
	@NotNull(message = "The state cannot be null")
	@NotEmpty(message = "The state cannot be empty")
	@Size(max = 25,  message = "The length of state is more than 25")
	private String state;
	
	@Column(name = "DISTRICT")
	@NotNull(message = "The district cannot be null")
	@NotEmpty(message = "The district cannot be empty")
	@Size(max = 25,  message = "The length of district is more than 25")
	private String districts;
	
	@Column(name = "POSTAL_CODE")
	@NotNull(message = "The postalCode cannot be null")
	@NotEmpty(message = "The postalCode cannot be empty")
	@Size(max = 10,  message = "The length of postalCode is more than 10")
	private String postalCode;
	
	public String getLineOne() {
		return lineOne;
	}
	
	public void setLineOne(String lineOne) {
		this.lineOne = lineOne;
	}
	
	public String getLineTwo() {
		return lineTwo;
	}
	
	public void setLineTwo(String lineTwo) {
		this.lineTwo = lineTwo;
	}
	
	public String getLineThree() {
		return lineThree;
	}
	
	public void setLineThree(String lineThree) {
		this.lineThree = lineThree;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getDistricts() {
		return districts;
	}
	
	public void setDistricts(String districts) {
		this.districts = districts;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "BaseAddress [type=" + type + ", lineOne=" + lineOne + ", lineTwo=" + lineTwo + ", lineThree="
				+ lineThree + ", city=" + city + ", country=" + country + ", state=" + state + ", districts="
				+ districts + ", postalCode=" + postalCode + "]";
	}	
}
