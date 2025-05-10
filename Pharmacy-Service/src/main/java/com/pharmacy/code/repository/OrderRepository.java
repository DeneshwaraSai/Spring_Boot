package com.pharmacy.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pharmacy.code.entity.OrderInfo;

@Repository
public interface OrderRepository extends JpaRepository<OrderInfo, String>{

	public OrderInfo findByOrderNumber(String orderNumber);
	
	public OrderInfo save(OrderInfo orderInfo);
}
