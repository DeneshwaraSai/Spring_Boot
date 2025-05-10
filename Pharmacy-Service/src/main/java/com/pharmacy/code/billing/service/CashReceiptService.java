package com.pharmacy.code.billing.service;

import com.pharmacy.code.billing.entity.CashReceipt;

public interface CashReceiptService {
	public CashReceipt findByTransactionId(String transactionId); 
	
	public CashReceipt save(CashReceipt cashReceipt);
	
	public CashReceipt update(CashReceipt cashReceipt);
}
