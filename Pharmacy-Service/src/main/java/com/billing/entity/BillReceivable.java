package com.billing.entity;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "BILL_RECEIVABLE")
public class BillReceivable {

	@Id
	@Column(name = "BILL_NUMBER", nullable = false, length = 36, unique = true)
	@Pattern(regexp = "^[a-zA-Z0-9_-]{36}$")
	private String billNumber;

	@Column(name="SEQUENCE_NUMBER")
	private String sequenceNumber;

	@Column(name = "BILL_DATE", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false)
	@NotNull(message = "Bill date cannot be null.")
	@Temporal(TemporalType.TIMESTAMP)
	private Date billDate;

	@Column(name = "CREATED_BY")
	@NotNull(message = "Created by cannot be null.")
	private String createdBy;

	@Column(name = "AMOUNT_PAID")
	@NotNull(message = "Amount paid cannot be null.")
	@Positive(message = "Amount paid should be greater than 0")
	private Integer amountPaid;

	@Column(name = "DUE_AMOUNT")
	private Double dueAmount;

	@Column(name = "LAST_MODIFIED_BY")
	private String lastModifiedBy;

	@Column(name = "STATUS")
	@NotNull(message = "Status cannot be null.")
	private String status;

	@Column(name = "NOTES") 
	@Size(min = 0, max = 50, message = "Notes cannot be more than 50 charcters.")
	private String notes;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "BILL_NUMBER", nullable = false)
	List<BillReceivableDetails> billReceivableDetails;

	public BillReceivable(String billNumber, String sequenceNumber, Date billDate, String createdBy, Integer amountPaid,
			Double dueAmount, String lastModifiedBy, String status, String notes, List<BillReceivableDetails> billReceivableDetails) {
		this.billNumber = billNumber;
		this.sequenceNumber = sequenceNumber;
		this.billDate = billDate;
		this.createdBy = createdBy;
		this.amountPaid = amountPaid;
		this.dueAmount = dueAmount;
		this.lastModifiedBy = lastModifiedBy;
		this.status = status;
		this.notes = notes;
		this.billReceivableDetails = billReceivableDetails;
	}

	public String getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(String billNumber) {
		if (StringUtils.isBlank(billNumber)) {
			this.billNumber = UUID.randomUUID().toString();
		} else {
			this.billNumber = billNumber;			
		}
	}

	public String getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(String sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(Integer amountPaid) {
		this.amountPaid = amountPaid;
	}

	public Double getDueAmount() {
		return dueAmount;
	}

	public void setDueAmount(Double dueAmount) {
		this.dueAmount = dueAmount;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public List<BillReceivableDetails> getBillReceivableDetails() {
		return billReceivableDetails;
	}

	public void setBillReceivableDetails(List<BillReceivableDetails> billReceivableDetails) {
		this.billReceivableDetails = billReceivableDetails;
	}

	@Override
	public String toString() {
		return "BillReceivable [billNumber=" + billNumber + ", sequenceNumber=" + sequenceNumber + ", billDate="
				+ billDate + ", createdBy=" + createdBy + ", amountPaid=" + amountPaid + ", dueAmount=" + dueAmount
				+ ", lastModifiedBy=" + lastModifiedBy + ", status=" + status + ", notes=" + notes
				+ ", billReceivableDetails=" + billReceivableDetails + "]";
	}
}
