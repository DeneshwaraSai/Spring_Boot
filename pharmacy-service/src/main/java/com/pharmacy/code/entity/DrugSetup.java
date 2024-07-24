package com.pharmacy.code.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "DRUG_SETUP")
public class DrugSetup {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "NAME", nullable = false, updatable = false, length = 50)
	@NotBlank(message = "Name cannot be empty")
	private String name;

	@Column(name = "TYPE", nullable = false, length = 5)
	@NotBlank(message = "Type cannot be empty")
	private String type;

	@Column(name = "UNITS_PER_PACK")
	private Float unitsPerPack;

	@Column(name = "HSN_CODE", nullable = false, length = 12)
	@NotBlank(message = "HSN Code cannot be empty")
	private String hsnCode;

	@Transient
	private Float cgst;

	@Transient
	private Float igst;

	@Transient
	private Float sgst;

	@Column(name = "STATUS", nullable = false, length = 2)
	@NotBlank(message = "Status cannot be empty")
	private String status;

	@Column(name = "COMPOSITION", length = 100)
	private String composition;

	@Column(name = "GENERIC_NAME", length = 100)
	private String genericName;

	public DrugSetup() {

	}

	public DrugSetup(Integer id,String name, String type, Float unitsPerPack,  String hsnCode,
			Float cgst, Float igst, Float sgst, String status, String composition, String genericName) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.unitsPerPack = unitsPerPack;
		this.hsnCode = hsnCode;
		this.cgst = cgst;
		this.igst = igst;
		this.sgst = sgst;
		this.status = status;
		this.composition = composition;
		this.genericName = genericName;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Float getUnitsPerPack() {
		return unitsPerPack;
	}

	public void setUnitsPerPack(Float unitsPerPack) {
		this.unitsPerPack = unitsPerPack;
	}

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
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

	public Float getSgst() {
		return sgst;
	}

	public void setSgst(Float sgst) {
		this.sgst = sgst;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComposition() {
		return composition;
	}

	public void setComposition(String composition) {
		this.composition = composition;
	}

	public String getGenericName() {
		return genericName;
	}

	public void setGenericName(String genericName) {
		this.genericName = genericName;
	}

	@Override
	public String toString() {
		return "DrugSetup [id=" + id + ", name=" + name + ", type=" + type + ", unitsPerPack=" + unitsPerPack
				+ ", hsnCode=" + hsnCode + ", cgst=" + cgst + ", igst=" + igst + ", sgst=" + sgst + ", status=" + status
				+ ", composition=" + composition + ", genericName=" + genericName + "]";
	}
}
