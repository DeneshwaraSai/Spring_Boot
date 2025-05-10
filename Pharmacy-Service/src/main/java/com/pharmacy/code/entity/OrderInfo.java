package com.pharmacy.code.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "ORDER_INFO")
public class OrderInfo {	
	@Id
	@Column(name = "ORDER_NUMBER")
	private String orderNumber;

	@Column(name = "UHID")
	@NotNull(message = "UHID cannot be null.")
	private Integer uhid;

	@Column(name="SEQUENCE_NUMBER")
	@NotBlank(message = "Sequence number cannot be empty.")
	private String sequenceNumber;

	@Column(name="BILL_NUMBER")
	@NotBlank(message = "Bill number cannot be empty.")
	private String billNumber;

	@Column(name="TRANSACTION_ID")
	@NotBlank(message = "Transaction-Id cannot be empty.")
	private String transactionId;

	@Column(name = "ORDER_DATE")
	@NotNull(message = "Order date cannot be null.")
	private Date orderDate;

	@Column(name = "LAST_MODIFIED_DATE")
	@NotNull(message = "Last modified date cannot be null.")
	private Date lastModifiedDate;

	@Column(name = "CREATED_BY")
	@NotNull(message = "Created by cannot be null.")
	private String createdBy;

	@Column(name = "LAST_MODIFIED_BY")
	private String lastModifiedBy;

	@Column(name = "AMOUNT_PAID")
	@NotNull(message = "Amount paid cannot be null.")
	@Positive(message = "Amount paid should be greater than 0")
	private Double amountPaid;

	@Column(name = "DUE_AMOUNT")
	private Double dueAmount;

	@Column(name = "STATUS")
	@NotNull(message = "Status cannot be null.")
	private String status;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ORDER_NUMBER", nullable = false)
	List<OrderDetails> orderDetails;

	public OrderInfo() { }

	public OrderInfo(String orderNumber, Integer uhid, String sequenceNumber, String billNumber, 
			String transactionId, Date orderDate, Date lastModifiedDate, String createdBy, String lastModifiedBy,
					 Double amountPaid, Double dueAmount, String status, List<OrderDetails> orderDetails) {
		this.orderNumber = orderNumber;
		this.uhid = uhid;
		this.sequenceNumber = sequenceNumber;
		this.billNumber = billNumber;
		this.transactionId = transactionId;
		this.orderDate = orderDate;
		this.lastModifiedDate = lastModifiedDate;
		this.createdBy = createdBy;
		this.lastModifiedBy = lastModifiedBy;
		this.amountPaid = amountPaid;
		this.dueAmount = dueAmount;
		this.status = status;
		this.orderDetails = orderDetails;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Integer getUhid() {
		return uhid;
	}

	public void setUhid(Integer uhid) {
		this.uhid = uhid;
	}

	public String getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(String sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public String getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(Double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public Double getDueAmount() {
		return dueAmount;
	}

	public void setDueAmount(Double dueAmount) {
		this.dueAmount = dueAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	@Override
	public String toString() {
		return "OrderInfo [orderNumber=" + orderNumber + ", uhid=" + uhid + ", sequenceNumber=" + sequenceNumber
				+ ", billNumber=" + billNumber + ", transactionId=" + transactionId + ", orderDate=" + orderDate
				+ ", lastModifiedDate=" + lastModifiedDate + ", createdBy=" + createdBy + ", lastModifiedBy="
				+ lastModifiedBy + ", amountPaid=" + amountPaid + ", dueAmount=" + dueAmount + ", status=" + status
				+ ", orderDetails=" + orderDetails + "]";
	}
}
