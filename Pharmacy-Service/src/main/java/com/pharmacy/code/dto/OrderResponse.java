package com.pharmacy.code.dto;

import com.pharmacy.code.billing.entity.BillReceivable;
import com.pharmacy.code.billing.entity.CashReceipt;
import com.pharmacy.code.entity.OrderInfo;

public class OrderResponse {
	
	OrderInfo orderResponse;

	BillReceivable billReceivableResponse;
	
	CashReceipt cashReceiptResponse;

	public OrderInfo getOrderResponse() {
		return orderResponse;
	}

	public void setOrderResponse(OrderInfo orderResponse) {
		this.orderResponse = orderResponse;
	}

	public BillReceivable getBillReceivableResponse() {
		return billReceivableResponse;
	}

	public void setBillReceivableResponse(BillReceivable billReceivableResponse) {
		this.billReceivableResponse = billReceivableResponse;
	}

	public CashReceipt getCashReceiptResponse() {
		return cashReceiptResponse;
	}

	public void setCashReceiptResponse(CashReceipt cashReceiptResponse) {
		this.cashReceiptResponse = cashReceiptResponse;
	}

	@Override
	public String toString() {
		return "OrderResponse [orderResponse=" + orderResponse + ", billReceivableResponse=" + billReceivableResponse
				+ ", cashReceiptResponse=" + cashReceiptResponse + "]";
	}
}
