package com.alumini.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "PROFESSIONAL_INFO")
public class ProfessionalInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "EMPLOYER_NAME", nullable = false, length = 100)
	@NotNull(message = "The employer name cannot be empty.")
	@Pattern(regexp = "[a-zA-Z. ]*\\.?", message = "Invalid employer name pattern")
	@Size(min = 1, max = 100, message = "The length of employer name is more than 100")
	private String employerName;
	
	@Column(name = "POSITION", nullable = false, length=50)
	@NotNull(message = "The position cannot be empty.")
	@Pattern(regexp = "[a-zA-Z. ]*\\.?", message = "Invalid position pattern")
	@Size(min = 1, max=50, message = "The length of position is more than 50")
	private String position;
	
	@Column(name = "START_DATE", nullable = true)
	@NotNull(message = "The start date cannot be empty")
	private Date startDate; 
	
	@Column(name = "END_DATE", nullable = true)
	private Date endDate;
	
	@Column(name ="AT_PRESENT")
	private boolean atPresent = false;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmployerName() {
		return employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean isAtPresent() {
		return atPresent;
	}

	public void setAtPresent(boolean atPresent) {
		this.atPresent = atPresent;
	}

	@Override
	public String toString() {
		return "ProfessionalInfo [id=" + id + ", employerName=" + employerName + ", position=" + position
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", atPresent=" + atPresent + "]";
	}
}
