package com.pharmacy.code.billing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmacy.code.billing.entity.CashReceipt;
import com.pharmacy.code.billing.repository.CashReceiptRepository;

import jakarta.persistence.EntityManager;

@Service
public class CashReceiptServiceImpl implements CashReceiptService {

	private CashReceiptRepository cashReceiptRepository;

	private EntityManager entityManager;

	@Autowired
	CashReceiptServiceImpl(CashReceiptRepository cashReceiptRepository, EntityManager entityManager) {
		this.cashReceiptRepository = cashReceiptRepository;
		this.entityManager = entityManager;
	}

	@Override
	public CashReceipt findByTransactionId(String transactionId) {
		// TODO Auto-generated method stub
		return cashReceiptRepository.findByTransactionId(transactionId);
	}

	@Override
	public CashReceipt save(CashReceipt cashReceipt) {
		// TODO Auto-generated method stub
		return cashReceiptRepository.save(cashReceipt);
	}

	@Override
	public CashReceipt update(CashReceipt cashReceipt) {
		// TODO Auto-generated method stub
		return cashReceiptRepository.save(cashReceipt);
	}
}
