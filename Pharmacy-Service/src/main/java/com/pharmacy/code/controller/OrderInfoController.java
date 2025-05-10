package com.pharmacy.code.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pharmacy.code.dto.OrderRequest;
import com.pharmacy.code.dto.OrderResponse;
import com.pharmacy.code.entity.OrderInfo;
import com.pharmacy.code.service.OrderService;

@CrossOrigin
@RestController
public class OrderInfoController {
	
	private OrderService orderService;
	
	@Autowired
	public OrderInfoController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@PostMapping("/order/create")
		public OrderResponse save(@RequestBody OrderRequest orderRequest) {
		// TODO Auto-generated method stub
		return orderService.save(orderRequest);
	}
}
