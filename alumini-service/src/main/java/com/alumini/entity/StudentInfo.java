package com.alumini.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "STUDENT_INFO")
public class StudentInfo extends Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "ABOUT", length = 1000)
	@Size(max = 1000, message = "The about of a student cannot be more than 1000 characters.")
	private String about;
	
	@Column (name = "ROLL_NO", nullable = false)
	@Size(max = 15, message = "Please provide Roll Number of the student")
	private String rollNo;
	
	@Column(name = "STATUS", nullable = true)
	@NotNull(message = "Status cannot be null")
	@NotEmpty(message = "Status cannot be empty")
	@Size(min = 1, max = 2, message = "The status cannot exceed 2 characters.")
	private String status;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "STUDENT_ID", nullable = false)
	List<Address> address;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "STUDENT_ID", nullable = false)
	List<Telephone> telephone;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "STUDENT_ID", nullable = false)
	List<QualificationInfo> qualificationInfo;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "STUDENT_ID", nullable = false)
	List<ProfessionalInfo> professionalInfo;
	
	public Integer getid() {
		return id;
	}

	public void setid(Integer id) {
		this.id = id;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}
	
	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public List<Telephone> getTelephone() {
		return telephone;
	}

	public void setTelephone(List<Telephone> telephone) {
		this.telephone = telephone;
	}

	public List<QualificationInfo> getQualificationInfo() {
		return qualificationInfo;
	}

	public void setQualificationInfo(List<QualificationInfo> qualificationInfo) {
		this.qualificationInfo = qualificationInfo;
	}

	public List<ProfessionalInfo> getProfessionalInfo() {
		return professionalInfo;
	}

	public void setProfessionalInfo(List<ProfessionalInfo> professionalInfo) {
		this.professionalInfo = professionalInfo;
	}

	@Override
	public String toString() {
		return "StudentInfo [id=" + id + ", about=" + about + ", rollNo=" + rollNo + ", status=" + status + ", address="
				+ address + ", telephone=" + telephone + ", qualificationInfo=" + qualificationInfo
				+ ", professionalInfo=" + professionalInfo + "]";
	}
}
