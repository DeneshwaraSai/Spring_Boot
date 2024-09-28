package com.pharmacy.code.entity;

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
@Table(name = "TAX_CATEGORY")
public class TaxCategory {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="CODE")
	@Size(min = 1, max = 20, message = "The code length should be between 1 and 20.")
	@NotBlank(message = "The code cannot be empty")
	private String code;

	@Column(name = "SGST", nullable = false, scale = 2)
	@NotNull
	private Float sgst;

	@Column(name = "CGST", nullable = false, scale = 2)
	@NotNull
	private Float cgst;

	@Column(name = "IGST", nullable = false, scale = 2)
	@NotNull
	private Float igst;

	// Constructor
	public TaxCategory() {}

	public TaxCategory(int id, String code, Float sgst, Float cgst, Float igst) {
		this.id = id;
		this.code = code;
		this.sgst = sgst;
		this.cgst = cgst;
		this.igst = igst;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Float getSgst() {
		return sgst;
	}

	public void setSgst(Float sgst) {
		this.sgst = sgst;
	}

	public Float getCgst() {
		return cgst;
	}

	public void setCgst(Float cgst) {
		this.cgst = cgst;
	}

	public Float getIgst() {
		return igst;
	}

	public void setIgst(Float igst) {
		this.igst = igst;
	}

	@Override
	public String toString() {
		return "TaxCategory [id=" + id + ", code=" + code + ", sgst=" + sgst + ", cgst=" + cgst + ", igst=" + igst
				+ "]";
	}
}
