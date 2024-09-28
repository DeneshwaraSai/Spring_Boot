package com.pharmacy.code.dto;

import java.util.Date;

public class InventoryDashboard {

	private Integer id;
	private String supplierCode;
	private String inventoryNumber;
	private String invoiceNumber;
	private Date invoiceDate;
	private Double invoiceAmt;
	private String status;
	private String createdBy;

	public InventoryDashboard() { }

	public InventoryDashboard(Integer id, String supplierCode, String inventoryNumber, String invoiceNumber,
			Date invoiceDate, Double invoiceAmt, String status, String createdBy) {
		super();
		this.id = id;
		this.supplierCode = supplierCode;
		this.inventoryNumber = inventoryNumber;
		this.invoiceNumber = invoiceNumber;
		this.invoiceDate = invoiceDate;
		this.invoiceAmt = invoiceAmt;
		this.status = status;
		this.createdBy = createdBy;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public String getInventoryNumber() {
		return inventoryNumber;
	}

	public void setInventoryNumber(String inventoryNumber) {
		this.inventoryNumber = inventoryNumber;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public Double getInvoiceAmt() {
		return invoiceAmt;
	}

	public void setInvoiceAmt(Double invoiceAmt) {
		this.invoiceAmt = invoiceAmt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public String toString() {
		return "InventoryDashboard [id=" + id + ", supplierCode=" + supplierCode + ", inventoryNumber="
				+ inventoryNumber + ", invoiceNumber=" + invoiceNumber + ", invoiceDate=" + invoiceDate
				+ ", invoiceAmt=" + invoiceAmt + ", status=" + status + ", createdBy=" + createdBy + "]";
	}
}