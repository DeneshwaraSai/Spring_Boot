package com.pharmacy.code.entity;

import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name="ORDER_DETIALS")
public class OrderDetails {

	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "SUPPLIER_CODE")
	@NotBlank(message = "Supplier code cannot be empty.")
	private String supplierCode;

	@Column(name = "BATCH_NUMBER")
	@NotBlank(message = "Batch number cannot be empty.")
	private String batchNumber;

	@Column(name = "DRUG_ID")
	@NotBlank(message = "Drug id cannot be empty.")
	private String drugId;

	@Column(name = "EXPIRY_DATE")
	@NotNull(message = "Expiry date cannot be null.")
	private Date expiryDate;

	@Transient
	private String drugName;

	@Column(name = "HSN_CODE")
	private String hsnCode;

	@Column(name = "QUANTITY")
	@NotNull(message = "Quantity cannot be null.")
	@Positive(message = "Quantity should be greater than 0")
	private Integer quantity;

	@Column(name = "UNIT_PRICE")
	@NotNull(message = "Unit price cannot be empty")
	@Min(value = 1, message = "Unit price should be greater than zero")
	private Double unitPrice;

	@Column(name = "TOTAL_PRICE")
	@NotNull(message = "Total price cannot be empty")
	@Min(value = 1, message = "Total price should be greater than zero")
	private Double totalPrice; 

	@Column(name = "DISCOUNT_AMOUNT") 
	private Double discountAmount;

	@Column(name = "DISCOUNT_PERC") 
	private Double discountPerc;

	@Column(name = "BILL_RECEIVABLE_ID")
	private String billReceivableDetailsId;

	@Column(name = "SGST")
	private Double sgst;

	@Column(name = "CGST")
	private Double cgst;

	public OrderDetails(String id, String supplierCode, String batchNumber, String drugId,
			Date expiryDate, String drugName, String hsnCode, Integer quantity, Double unitPrice, Double totalPrice, 
			Double discountAmount, Double discountPerc, String billReceivableDetailsId, Double sgst, Double cgst) {
		this.id = id;
		this.supplierCode = supplierCode;
		this.batchNumber = batchNumber;
		this.drugId = drugId;
		this.expiryDate = expiryDate;
		this.drugName = drugName;
		this.hsnCode = hsnCode;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.totalPrice = totalPrice;
		this.discountAmount = discountAmount;
		this.discountPerc = discountPerc;
		this.billReceivableDetailsId = billReceivableDetailsId;
		this.sgst = sgst;
		this.cgst = cgst;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		if (StringUtils.isBlank(id)) {
			this.id = UUID.randomUUID().toString();
		} else {
			this.id = id;
		}
	}

	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public String getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public String getDrugId() {
		return drugId;
	}

	public void setDrugId(String drugId) {
		this.drugId = drugId;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(Double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public Double getDiscountPerc() {
		return discountPerc;
	}

	public void setDiscountPerc(Double discountPerc) {
		this.discountPerc = discountPerc;
	}

	public String getBillReceivableDetailsId() {
		return billReceivableDetailsId;
	}

	public void setBillReceivableDetailsId(String billReceivableDetailsId) {
		this.billReceivableDetailsId = billReceivableDetailsId;
	}

	public Double getSgst() {
		return sgst;
	}

	public void setSgst(Double sgst) {
		this.sgst = sgst;
	}

	public Double getCgst() {
		return cgst;
	}

	public void setCgst(Double cgst) {
		this.cgst = cgst;
	}

	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", supplierCode=" + supplierCode + ", batchNumber=" + batchNumber
				+ ", drugId=" + drugId + ", expiryDate=" + expiryDate + ", drugName=" + drugName + ", hsnCode="
				+ hsnCode + ", quantity=" + quantity + ", unitPrice=" + unitPrice + ", totalPrice=" + totalPrice
				+ ", discountAmount=" + discountAmount + ", discountPerc=" + discountPerc + ", billReceivableDetailsId="
				+ billReceivableDetailsId + ", sgst=" + sgst + ", cgst=" + cgst + ", getId()=" + getId()
				+ ", getSupplierCode()=" + getSupplierCode() + ", getBatchNumber()=" + getBatchNumber()
				+ ", getDrugId()=" + getDrugId() + ", getExpiryDate()=" + getExpiryDate() + ", getDrugName()="
				+ getDrugName() + ", getHsnCode()=" + getHsnCode() + ", getQuantity()=" + getQuantity()
				+ ", getUnitPrice()=" + getUnitPrice() + ", getTotalPrice()=" + getTotalPrice()
				+ ", getDiscountAmount()=" + getDiscountAmount() + ", getDiscountPerc()=" + getDiscountPerc()
				+ ", getBillReceivableDetailsId()=" + getBillReceivableDetailsId() + ", getSgst()=" + getSgst()
				+ ", getCgst()=" + getCgst() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
}
