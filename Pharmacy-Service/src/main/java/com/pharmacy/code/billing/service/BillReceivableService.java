package com.pharmacy.code.billing.service;

import com.pharmacy.code.billing.entity.BillReceivable;

public interface BillReceivableService {
	
	public BillReceivable save(BillReceivable billReceivable);
	
	public BillReceivable findByBillNumber(String billNumber);
}
