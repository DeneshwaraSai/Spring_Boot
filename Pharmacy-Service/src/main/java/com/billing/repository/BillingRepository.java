package com.billing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.billing.entity.BillReceivable;

public interface BillingRepository extends JpaRepository<BillReceivable	, String> {
	
	public BillReceivable save(BillReceivable billReceivable);
		 
	public List<BillReceivable> findAll();
	
	public BillReceivable findByBillNumber(String billNumber);

}
