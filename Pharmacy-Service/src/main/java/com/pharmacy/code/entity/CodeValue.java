package com.pharmacy.code.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "CODE_VALUE")
public class CodeValue {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
    private Integer id;

    @Column(name = "CODE", length = 3)
    @NotBlank(message = "The code cannot be empty.")
    private String code;

    @Column(name = "VALUE", length = 25)
    @NotBlank(message = "The value cannot be empty.")
    private String value;

    @Column(name = "DOMAIN_NAME", length = 25)
    @NotBlank(message = "The domain name cannot be empty.")
    private String domainName;

    @Column(name = "STATUS", length = 1)
    @NotBlank(message = "The status cannot be empty.")
    private String status;

	public CodeValue() {
		
	}

	public CodeValue(Integer id, String code, String value, String domainName, String status) {
		this.id = id;
		this.code = code;
		this.value = value;
		this.domainName = domainName;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CodeValue [id=" + id + ", code=" + code + ", value=" + value + ", domainName=" + domainName
				+ ", status=" + status + "]";
	}
}
