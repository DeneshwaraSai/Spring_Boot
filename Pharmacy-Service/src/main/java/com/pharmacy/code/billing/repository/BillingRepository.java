package com.pharmacy.code.billing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pharmacy.code.billing.entity.BillReceivable;

@Repository
public interface BillingRepository extends JpaRepository<BillReceivable	, String> {
	
	public BillReceivable save(BillReceivable billReceivable);
		 
	public List<BillReceivable> findAll();
	
	public BillReceivable findByBillNumber(String billNumber);

}
