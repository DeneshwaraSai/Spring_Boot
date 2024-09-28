package com.pharmacy.code.service;

import com.pharmacy.code.entity.OrderInfo;

public interface OrderService {
	public OrderInfo findByOrderNumber(String orderNumber);

	public OrderInfo save(OrderInfo orderInfo);

	public OrderInfo update(OrderInfo orderInfo);
}
