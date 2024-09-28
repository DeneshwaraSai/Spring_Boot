package com.pharmacy.code.dto;

import java.util.Date;

public class InventorySearchDto {
	private Integer drugCode;
	private String supplierCode;
	private String supplierName;
	private String drugName;
	private String batchNumber;
	private String hsnCode;
	private Date expiryDate;
	private Integer quantity;
	private Float sellingCost;
	private Float totalSellingCost;
	private Float cgst;
	private Float sgst;

	// Constructor
	public InventorySearchDto() { }

	public InventorySearchDto(Integer drugCode, String supplierCode, String supplierName, 
			String drugName, String batchNumber, String hsnCode, Date expiryDate, Integer quantity, 
			Float sellingCost, Float totalSellingCost, Float cgst, Float sgst) {
		this.drugCode = drugCode;
		this.supplierCode = supplierCode;
		this.supplierName = supplierName;
		this.drugName = drugName;
		this.batchNumber = batchNumber;
		this.hsnCode = hsnCode;
		this.expiryDate = expiryDate;
		this.quantity = quantity;
		this.sellingCost = sellingCost;
		this.totalSellingCost = totalSellingCost;
		this.cgst = cgst;
		this.sgst = sgst;
	}

	public Integer getDrugCode() {
		return drugCode;
	}

	public void setDrugCode(Integer drugCode) {
		this.drugCode = drugCode;
	}

	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public String getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Float getSellingCost() {
		return sellingCost;
	}

	public void setSellingCost(Float sellingCost) {
		this.sellingCost = sellingCost;
	}

	public Float getTotalSellingCost() {
		return totalSellingCost;
	}

	public void setTotalSellingCost(Float totalSellingCost) {
		this.totalSellingCost = totalSellingCost;
	}

	public Float getCgst() {
		return cgst;
	}

	public void setCgst(Float cgst) {
		this.cgst = cgst;
	}

	public Float getSgst() {
		return sgst;
	}

	public void setSgst(Float sgst) {
		this.sgst = sgst;
	}

	@Override
	public String toString() {
		return "InventorySearchDto [drugCode=" + drugCode + ", supplierCode=" + supplierCode + ", supplierName="
				+ supplierName + ", drugName=" + drugName + ", batchNumber=" + batchNumber + ", hsnCode=" + hsnCode
				+ ", expiryDate=" + expiryDate + ", quantity=" + quantity + ", sellingCost=" + sellingCost
				+ ", totalSellingCost=" + totalSellingCost + ", cgst=" + cgst + ", sgst=" + sgst + "]";
	}
}
