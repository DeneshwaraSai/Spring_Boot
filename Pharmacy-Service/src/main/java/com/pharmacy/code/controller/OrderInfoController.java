package com.pharmacy.code.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
		public OrderInfo save(@RequestBody OrderInfo orderInfo) {
		// TODO Auto-generated method stub
		return orderService.save(orderInfo);
	}
}
