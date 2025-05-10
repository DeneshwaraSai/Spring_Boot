package com.pharmacy.code.service;

import com.pharmacy.code.dto.OrderRequest;
import com.pharmacy.code.dto.OrderResponse;
import com.pharmacy.code.entity.OrderInfo;

public interface OrderService {
	public OrderInfo findByOrderNumber(String orderNumber);

	public OrderResponse save(OrderRequest orderRequest);

	public OrderInfo update(OrderInfo orderInfo);
}
