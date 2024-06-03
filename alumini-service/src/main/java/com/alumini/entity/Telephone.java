package com.alumini.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TELEPHONE")
public class Telephone extends BaseTelephone implements Serializable {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getid() {
		return id;
	}

	public void setid(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Telephone [id=" + id + "]";
	}	
}
