package com.pharmacy.code.billing.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name= "CASH_RECEIPT")
public class CashReceipt {

	@Id
	@Column(name = "TRANSACTION_ID")
	@NotBlank(message = "Transaction-ID in cash receipt cannot be empty.")
	private String transactionId;

	@Column(name = "BILL_NUMBER")
	@NotBlank(message = "Bill number in cash receipt cannot be empty.")
	private String billNumber;

	@Column(name ="AMOUNT_PAID")
	@Positive(message = "The amount paid should minimum be 1")
	private Double amountPaid;
	
	@Column(name = "PAYMENT_TYPE")
    private String paymentType;

    @Column(name = "BANK_NAME")
    private String bankName;

    @Column(name = "RECEIPT_TYPE")
    @NotBlank(message = "Receipt type in cash receipt cannot be empty.")
    private String receiptType;

    @Column(name = "NOTES")
    private String notes;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RECEIVED_DATE")
    private Date receivedDate;

    @Column(name = "RECEIVED_BY")
    private String receivedBy;

    public CashReceipt() {
    	
    }
    
	public CashReceipt(String transactionId, String billNumber, Double amountPaid, String paymentType,
			String bankName, String receiptType, String notes, Date receivedDate, String receivedBy) {
		super();
		this.transactionId = transactionId;
		this.billNumber = billNumber;
		this.amountPaid = amountPaid;
		this.paymentType = paymentType;
		this.bankName = bankName;
		this.receiptType = receiptType;
		this.notes = notes;
		this.receivedDate = receivedDate;
		this.receivedBy = receivedBy;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}

	public Double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(Double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getReceiptType() {
		return receiptType;
	}

	public void setReceiptType(String receiptType) {
		this.receiptType = receiptType;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Date getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}

	public String getReceivedBy() {
		return receivedBy;
	}

	public void setReceivedBy(String receivedBy) {
		this.receivedBy = receivedBy;
	}

	@Override
	public String toString() {
		return "CashReceipt [transactionId=" + transactionId + ", billNumber=" + billNumber + ", amountPaid="
				+ amountPaid + ", paymentType=" + paymentType + ", bankName=" + bankName + ", receiptType="
				+ receiptType + ", notes=" + notes + ", receivedDate=" + receivedDate + ", receivedBy=" + receivedBy
				+ "]";
	}
    
    
}
