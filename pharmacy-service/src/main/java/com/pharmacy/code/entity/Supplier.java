package com.pharmacy.code.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "SUPPLIER")
public class Supplier {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "NAME", nullable = false, updatable = false, length = 50)
	@Size(min=1, max = 50, message = "The length of name should be between 1 and 50")
	@NotBlank(message =  "Name cannot be empty")
	private String name;

	@Column(name = "CODE", nullable = false, updatable = false, length = 5)
	@NotBlank(message =  "Code cannot be empty")
	@Size(min=1, max = 5, message = "The length of name should be between 1 and 5")
	private String code;

	@Column(name = "ACCOUNT_NUMBER", length = 20)
	@Size(min=0, max=20, message = "The length of account number should be between 1 and 5")
	private String accountNumber;

	@Column(name = "ACCOUNT_HOLDER_NAME", length = 50)
	@Size(min=0, max= 50, message = "The length of account holder name should be between 1 and 50")
	private String accountHolderName;

	@Column(name = "IFSC_CODE", length = 20)
	@Size(min=0, max= 20, message = "The length of ifsc code should be between 1 and 50")
	private String ifscCode;

	@Column(name = "TAX_NUMBER", length = 15)
	@Size(min = 0, max = 15, message = "The length of tax number should be between 0 and 15")
	private String taxNumber;

	@Column(name = "LICENCE_NUMBER", length = 15)
	@Size(min = 0, max = 15, message = "The length of licence number should be between 0 and 15")
	private String licenceNumber;

	@Column(name = "EMAIL", length = 30)
	@Size(min = 0, max = 30, message = "The length of email should be between 0 and 30")
	@Email(message = "Email should be valid")
	private String email;

	@Column(name = "PHONE_NUMBER", length = 10)
	@Size(min = 0, max = 10, message = "The length of phoneNumber should be between 0 and 10")
	private String phoneNumber;

	@Column(name = "STATUS", nullable = false, length = 2)
	@Size(min = 1, max = 2, message = "The length of status should be between 1 and 2")
	private String status;

	public Supplier() {

	}

	public Supplier(Integer id, String name, String code, String accountNumber, String accountHolderName,
			String ifscCode, String taxNumber, String licenceNumber, String email, String phoneNumber, String status) {
		this.id = id;
		this.name = name;
		this.code = code;
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.ifscCode = ifscCode;
		this.taxNumber = taxNumber;
		this.licenceNumber = licenceNumber;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getTaxNumber() {
		return taxNumber;
	}

	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}

	public String getLicenceNumber() {
		return licenceNumber;
	}

	public void setLicenceNumber(String licenceNumber) {
		this.licenceNumber = licenceNumber;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Supplier [id=" + id + ", name=" + name + ", code=" + code + ", accountNumber=" + accountNumber
				+ ", accountHolderName=" + accountHolderName + ", ifscCode=" + ifscCode + ", taxNumber=" + taxNumber
				+ ", licenceNumber=" + licenceNumber + ", email=" + email + ", phoneNumber=" + phoneNumber + ", status="
				+ status + "]";
	}
}
