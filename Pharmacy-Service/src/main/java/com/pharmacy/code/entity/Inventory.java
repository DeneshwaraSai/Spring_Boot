package com.pharmacy.code.entity;

import java.util.Date;
import java.util.List;

import com.pharmacy.validation.ValidCode;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "INVENTORY", uniqueConstraints =  @UniqueConstraint(columnNames = "INVENTORY_NUMBER" ))
public class Inventory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "SUPPLIER_CODE")
	//	@ValidCode(value = "SUPPLIER", message = "Invalid supplier code")
	@NotBlank(message = "Supplier Code cannot be empty")
	@Size(min=1, max = 5, message = "The length of supplier should be between 1 and 5")
	private String supplierCode;

	@Column(name = "INVOICE_NUMBER")
	@NotBlank(message = "Invoice Number cannot be empty")
	private String invoiceNumber;

	@Column(name = "INVOICE_DATE")
	@NotNull(message = "Invoice Date cannot be empty")
	private Date invoiceDate;

	@Column(name = "DISCOUNT_PERC")
	private Double discountPerc;

	@Column(name = "DISCOUNT_AMT")
	private Double discountAmt;

	@Column(name = "INVOICE_AMT")
	private Double invoiceAmt;

	@Column(name = "NOTES")
	private String notes;

	@Column(name = "INVENTORY_NUMBER")
	@NotBlank(message = "Inventory Number cannot be empty")
	private String inventoryNumber;

	@Column(name = "STATUS", nullable = false)
	@NotBlank(message = "Inventory status cannot be empty")
	private String status;
	
	@Column(name = "CREATED_BY", nullable = false)
	@NotBlank(message = "Created by cannot be empty")
	private String createdBy;
	
	@Column(name = "CREATED_DATE", nullable = false)
	@NotNull(message = "Created date cannot be empty")
	private Date createdDate;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "INVENTORY_DETAILS_ID", nullable = false)
	List<InventoryDetails> inventoryDetails;

	public Inventory(Integer id, String supplierCode, String invoiceNumber, Date invoiceDate, Double discountPerc,
			Double discountAmt, Double invoiceAmt, String notes, String inventoryNumber, String status,
			String createdBy, Date createdDate, List<InventoryDetails> inventoryDetails) {
		this.id = id;
		this.supplierCode = supplierCode;
		this.invoiceNumber = invoiceNumber;
		this.invoiceDate = invoiceDate;
		this.discountPerc = discountPerc;
		this.discountAmt = discountAmt;
		this.invoiceAmt = invoiceAmt;
		this.notes = notes;
		this.inventoryNumber = inventoryNumber;
		this.status = status;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.inventoryDetails = inventoryDetails;
	}

	public Inventory() { }

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

	public Double getDiscountPerc() {
		return discountPerc;
	}

	public void setDiscountPerc(Double discountPerc) {
		this.discountPerc = discountPerc;
	}

	public Double getDiscountAmt() {
		return discountAmt;
	}

	public void setDiscountAmt(Double discountAmt) {
		this.discountAmt = discountAmt;
	}

	public Double getInvoiceAmt() {
		return invoiceAmt;
	}

	public void setInvoiceAmt(Double invoiceAmt) {
		this.invoiceAmt = invoiceAmt;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getInventoryNumber() {
		return inventoryNumber;
	}

	public void setInventoryNumber(String inventoryNumber) {
		this.inventoryNumber = inventoryNumber;
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public List<InventoryDetails> getInventoryDetails() {
		return inventoryDetails;
	}

	public void setInventoryDetails(List<InventoryDetails> inventoryDetails) {
		this.inventoryDetails = inventoryDetails;
	}

	@Override
	public String toString() {
		return "Inventory [id=" + id + ", supplierCode=" + supplierCode + ", invoiceNumber=" + invoiceNumber
				+ ", invoiceDate=" + invoiceDate + ", discountPerc=" + discountPerc + ", discountAmt=" + discountAmt
				+ ", invoiceAmt=" + invoiceAmt + ", notes=" + notes + ", inventoryNumber=" + inventoryNumber
				+ ", status=" + status + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", inventoryDetails=" + inventoryDetails + "]";
	}
}
