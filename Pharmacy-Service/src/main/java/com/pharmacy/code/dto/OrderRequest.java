package com.pharmacy.code.dto;

import com.pharmacy.code.billing.entity.CashReceipt;
import com.pharmacy.code.entity.OrderDetails;
import com.pharmacy.code.entity.OrderInfo;

import java.util.List;

public class OrderRequest {

	private OrderInfo orderInfo;

	private List<OrderDetails> orderItems;

	private CashReceipt cashReceipt;
	
	private Double dueAmount;
	
	private String orderStatus;

	private Integer uhid;

	public OrderRequest(CashReceipt cashReceipt, List<OrderDetails> orderItems, OrderInfo orderInfo, Integer uhid) {
		this.cashReceipt = cashReceipt;
		this.orderItems = orderItems;
		this.orderInfo = orderInfo;
		this.uhid = uhid;
	}

	public OrderInfo getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(OrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}

	public CashReceipt getCashReceipt() {
		return cashReceipt;
	}

	public void setCashReceipt(CashReceipt cashReceipt) {
		this.cashReceipt = cashReceipt;
	}
	
	public Double getDueAmount() {
		return dueAmount;
	}

	public void setDueAmount(Double dueAmount) {
		this.dueAmount = dueAmount;
	}
	
	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public List<OrderDetails> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderDetails> orderItems) {
		this.orderItems = orderItems;
	}

	public Integer getUhid() {
		return uhid;
	}

	public void setUhid(Integer uhid) {
		this.uhid = uhid;
	}

	@Override
	public String toString() {
		return "OrderRequest{" +
				"orderInfo=" + orderInfo +
				", orderItems=" + orderItems +
				", cashReceipt=" + cashReceipt +
				", dueAmount=" + dueAmount +
				", orderStatus='" + orderStatus + '\'' +
				", uhid=" + uhid +
				'}';
	}
}
