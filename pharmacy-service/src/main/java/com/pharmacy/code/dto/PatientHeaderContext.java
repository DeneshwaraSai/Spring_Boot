package com.pharmacy.code.dto;

public class PatientHeaderContext {
	
	private Integer patientId;
	private String firstName;
	private String lastName;
	private Integer uhid;
	private String phoneNumber;
	private Integer age;
	private String gender;
	private String orderNumber;
	private String orderStatus;

	public PatientHeaderContext() {}

	public PatientHeaderContext(Integer patientId, String firstName, String lastName, Integer uhid, String phoneNumber, Integer age, String gender, String orderNumber, String orderStatus) {
		this.patientId = patientId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.uhid = uhid;
		this.phoneNumber = phoneNumber;
		this.age = age;
		this.gender = gender;
		this.orderNumber = orderNumber;
		this.orderStatus = orderStatus;
	}

	public Integer getId() {
		return patientId;
	}

	public void setId(Integer id) {
		this.patientId = id;
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

	public Integer getUhid() {
		return uhid;
	}

	public void setUhid(Integer uhid) {
		this.uhid = uhid;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "PatientHeaderContext [id=" + patientId + ", firstName=" + firstName + ", lastName=" + lastName + ", uhid="
				+ uhid + ", phoneNumber=" + phoneNumber + ", age=" + age + ", gender=" + gender + ", orderNumber="
				+ orderNumber + ", orderStatus=" + orderStatus + "]";
	}
}
