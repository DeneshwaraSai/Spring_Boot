package com.billing.entity;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.annotation.Transient;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "BILL_RECEIVABLE_DETAILS")
public class BillReceivableDetails {

	@Id
	@Column(name = "ID", nullable = false, length = 36, unique=true)
	@NotEmpty(message = "{Id cannoit be empty.s}")
	private String id = UUID.randomUUID().toString();

	@Column(name = "SERVICE_CODE")
	@NotBlank(message = "Service code cannot be null.")
	private String serviceCode;

	@Column(name = "SERVICE_Name")
	@NotBlank(message = "Service name cannot be null.")
	private String serviceName;

	@Column(name = "HSN_CODE")
	private String hsnCode;

	@Column(name = "QUANTITY")
	@NotNull(message = "Quantity cannot be null.")
	@Positive(message = "Quantity should be greater than 0")
	private Integer quantity;

	@Column(name = "PRICE")
	@NotNull(message = "Unit price cannot be empty")
	@Min(value = 1, message = "Unit price should be greater than zero")
	private Double unitPrice;

	@Column(name = "TOTAL_PRICE")
	@NotNull(message = "Total price cannot be null.")
	@Positive(message = "Total price should be greater than 0")
	private Double totalPrice ;

	@Column(name = "DISCOUNT_AMOUNT") 
	private Double discountAmount;

	@Column(name = "DISCOUNT_PERC") 
	private Double discountPerc; 

	@Transient
	private Double netAmount; 

	@Column(name = "SGST")
	private Double sgst;

	@Column(name = "CGST")
	private Double cgst;

	@Column(name = "IS_PHARMACY")
	private Boolean isPharmacy;

	@Column(name="TRANSACTION_ID")
	@NotBlank(message = "Transaction-Id cannot be empty.")
	private String transactionId;

	public BillReceivableDetails(String id, String serviceCode, String serviceName, String hsnCode, Integer quantity,
			Double unitPrice, Double totalPrice, Double discountAmount, Double discountPerc, Double netAmount, Double sgst, 
			Double cgst, Boolean isPharmacy, String transactionId) {
		this.id = id;
		this.serviceCode = serviceCode;
		this.serviceName = serviceName;
		this.hsnCode = hsnCode;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.totalPrice = totalPrice;
		this.discountAmount = discountAmount;
		this.discountPerc = discountPerc;
		this.netAmount = netAmount;
		this.sgst = sgst;
		this.cgst = cgst;
		this.isPharmacy = isPharmacy;
		this.transactionId = transactionId;
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

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
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

	public Double getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(Double netAmount) {
		this.netAmount = netAmount;
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

	public Boolean getIsPharmacy() {
		return isPharmacy;
	}

	public void setIsPharmacy(Boolean isPharmacy) {
		this.isPharmacy = isPharmacy;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	@Override
	public String toString() {
		return "BillReceivableDetails [id=" + id + ", serviceCode=" + serviceCode + ", serviceName=" + serviceName
				+ ", hsnCode=" + hsnCode + ", quantity=" + quantity + ", unitPrice=" + unitPrice + ", totalPrice="
				+ totalPrice + ", discountAmount=" + discountAmount + ", discountPerc=" + discountPerc + ", netAmount="
				+ netAmount + ", sgst=" + sgst + ", cgst=" + cgst + ", isPharmacy=" + isPharmacy + ", transactionId="
				+ transactionId + "]";
	}
}
