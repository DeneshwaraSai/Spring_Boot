package com.pharmacy.code.dto;

public class DrugSetupDto {

	private Integer id;
	private String name;
	private String type;
	private String hsnCode;
	private Float sgst;
	private Float cgst;
	private Float igst;
	private String genericName;
	private String status;

	public DrugSetupDto() {

	}

	public DrugSetupDto(Integer id, String name, String type, String hsnCode, Float sgst, Float cgst, Float igst,
			String genericName, String status) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.hsnCode = hsnCode;
		this.sgst = sgst;
		this.cgst = cgst;
		this.igst = igst;
		this.genericName = genericName;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
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

	public String getGenericName() {
		return genericName;
	}

	public void setGenericName(String genericName) {
		this.genericName = genericName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "DrugSetupDto [id=" + id + ", name=" + name + ", type=" + type + ", hsnCode=" + hsnCode + ", sgst="
				+ sgst + ", cgst=" + cgst + ", igst=" + igst + ", genericName=" + genericName + ", status=" + status
				+ "]";
	}
}
