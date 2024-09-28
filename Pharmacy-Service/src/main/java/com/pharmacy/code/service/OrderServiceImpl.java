package com.pharmacy.code.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pharmacy.code.entity.OrderInfo;
import com.pharmacy.code.repository.OrderRepository;

@Repository
public class OrderServiceImpl implements OrderService {

	private OrderRepository orderRepository;
	
	@Autowired
	public OrderServiceImpl(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
	@Override
	public OrderInfo findByOrderNumber(String orderNumber) {
		// TODO Auto-generated method stub
		return orderRepository.findByOrderNumber(orderNumber);
	}

	@Override
	public OrderInfo save(OrderInfo orderInfo) {
		// TODO Auto-generated method stub
		
//		return orderRepository.save(orderInfo);
		return orderInfo;
	}

	@Override
	public OrderInfo update(OrderInfo orderInfo) {
		// TODO Auto-generated method stub
		return orderRepository.save(orderInfo);
	}
}
