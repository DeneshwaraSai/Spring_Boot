package com.pharmacy.code.entity;

import java.util.Date;

import org.hibernate.annotations.Formula;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "INVENTORY_DETAILS")
public class InventoryDetails {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "DRUG_CODE")
	@NotNull(message = "Drug Code cannot be empty")
	private Integer drugCode;

	@Formula("(SELECT D.NAME FROM DRUG_SETUP D WHERE D.ID = DRUG_CODE)")
	private String drugName;

	@Column(name = "BATCH_NUMBER")
	@NotBlank(message = "Batch Number cannot be empty")
	private String batchNumber;

	@Column(name = "EXPIRY_DATE")
	@NotNull(message = "Expiry Date cannot be empty")
	private Date expiryDate;

	@Column(name = "STRIP_SIZE")
	private Integer stripSize;

	@Column(name = "QUANTITY")
	@Min(value = 1, message = "Quantity should be greater than zero")
	private Integer quantity;

	@Column(name = "HSN_CODE")
	private String hsnCode;

	@Column(name = "CGST")
	private Double cgst;

	@Column(name = "SGST")
	private Double sgst;

	@Column(name = "MANUFACTURER_RATE")
	@NotNull(message = "Manufacturer Rate cannot be empty")
	@Min(value = 1, message = "Manufacturer Rate should be greater than zero")
	private Double manufacturerRate;

	@Column(name = "TOTAL_MANUFACTURER_RATE")
	private Double totalManufacturerRate;

	@Column(name = "NET_AMOUNT")
	private Double netAmount;

	@Column(name = "INVOICE_AMOUNT")
	private Double invoiceAmount;

	@Column(name = "SELLING_COST")
	@NotNull(message = "Selling Cost cannot be empty")
	@Min(value = 1, message = "Selling Cost should be greater than zero")
	private Double sellingCost;

	@Column(name = "TOTAL_SELLING_COST")
	private Double totalSellingCost;

	public InventoryDetails(Integer id, Integer drugCode, String batchNumber, Date expiryDate, Integer stripSize,
			Integer quantity, String hsnCode, Double cgst, Double sgst,  Double manufacturerRate, Double totalManufacturerRate, 
			Double netAmount, Double invoiceAmount, Double sellingCost, Double totalSellingCost) {
		this.id = id;
		this.drugCode = drugCode;
		this.batchNumber = batchNumber;
		this.expiryDate = expiryDate;
		this.stripSize = stripSize;
		this.quantity = quantity;
		this.hsnCode = hsnCode;
		this.cgst = cgst;
		this.sgst = sgst;
		this.manufacturerRate = manufacturerRate;
		this.totalManufacturerRate = totalManufacturerRate;
		this.netAmount = netAmount;
		this.invoiceAmount = invoiceAmount;
		this.sellingCost = sellingCost;
		this.totalSellingCost = totalSellingCost;
	}

	public InventoryDetails() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDrugCode() {
		return drugCode;
	}

	public void setDrugCode(Integer drugCode) {
		this.drugCode = drugCode;
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

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Integer getStripSize() {
		return stripSize;
	}

	public void setStripSize(Integer stripSize) {
		this.stripSize = stripSize;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public Double getCgst() {
		return cgst;
	}

	public void setCgst(Double cgst) {
		this.cgst = cgst;
	}

	public Double getSgst() {
		return sgst;
	}

	public void setSgst(Double sgst) {
		this.sgst = sgst;
	}

	public Double getManufacturerRate() {
		return manufacturerRate;
	}

	public void setManufacturerRate(Double manufacturerRate) {
		this.manufacturerRate = manufacturerRate;
	}

	public Double getTotalManufacturerRate() {
		return totalManufacturerRate;
	}

	public void setTotalManufacturerRate(Double totalManufacturerRate) {
		this.totalManufacturerRate = totalManufacturerRate;
	}

	public Double getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(Double netAmount) {
		this.netAmount = netAmount;
	}

	public Double getInvoiceAmount() {
		return invoiceAmount;
	}

	public void setInvoiceAmount(Double invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	public Double getSellingCost() {
		return sellingCost;
	}

	public void setSellingCost(Double sellingCost) {
		this.sellingCost = sellingCost;
	}

	public Double getTotalSellingCost() {
		return totalSellingCost;
	}

	public void setTotalSellingCost(Double totalSellingCost) {
		this.totalSellingCost = totalSellingCost;
	}

	@Override
	public String toString() {
		return "InventoryDetails [id=" + id + ", drugCode=" + drugCode + ", drugName=" + drugName + ", batchNumber="
				+ batchNumber + ", expiryDate=" + expiryDate + ", stripSize=" + stripSize + ", quantity=" + quantity
				+ ", hsnCode=" + hsnCode + ", cgst=" + cgst + ", sgst=" + sgst + ", manufacturerRate="
				+ manufacturerRate + ", totalManufacturerRate=" + totalManufacturerRate + ", netAmount=" + netAmount
				+ ", invoiceAmount=" + invoiceAmount + ", sellingCost=" + sellingCost + ", totalSellingCost="
				+ totalSellingCost + "]";
	}
}
