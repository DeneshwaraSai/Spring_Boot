package com.pharmacy.code.billing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pharmacy.code.billing.entity.CashReceipt;

@Repository
public interface CashReceiptRepository extends JpaRepository<CashReceipt, String> {
	
	public CashReceipt findByTransactionId(String transactionId); 
	
	public CashReceipt save(CashReceipt cashReceipt);
}
