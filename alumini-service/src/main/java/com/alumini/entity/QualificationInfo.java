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
@Table(name = "QUALIFICATION_INFO")
public class QualificationInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "QUALIFICATION_NAME", nullable = false, length = 100)
	@NotNull(message = "The qualification name cannot be empty.")
	@Pattern(regexp = "[a-zA-Z. ]*\\.?", message = "Invalid qualification name pattern")
	@Size(min = 1, max = 100, message = "The length of qualification name is more than 100")
	private String qualificationName;
	
	@Column(name = "SCHOOL_NAME", nullable = false, length = 100)
	@NotNull(message = "The school name cannot be empty.")
	@Pattern(regexp = "[a-zA-Z. ]*\\.?", message = "Invalid school name pattern")
	@Size(min = 1, max = 100, message = "The length of school name is more than 100")
	private String schoolName;

	@Column(name = "START_DATE", nullable = false)
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

	public String getQualificationName() {
		return qualificationName;
	}

	public void setQualificationName(String qualificationName) {
		this.qualificationName = qualificationName;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
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
		return "QualificationInfo [id=" + id + ", qualificationName=" + qualificationName + ", schoolName=" + schoolName
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", atPresent=" + atPresent + "]";
	}
}
