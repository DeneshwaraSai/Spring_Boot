package com.pharmacy.code.billing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmacy.code.billing.entity.BillReceivable;
import com.pharmacy.code.billing.repository.BillingRepository;

import jakarta.persistence.EntityManager;

@Service
public class BillReceivableServiceImpl implements BillReceivableService {

	private BillingRepository billingRepository;
	
	private EntityManager entityManager;
	
	@Autowired
	public BillReceivableServiceImpl(BillingRepository billingRepository, EntityManager entityManager) {
		this.billingRepository = billingRepository;
		this.entityManager = entityManager;
	}
	
	@Override
	public BillReceivable save(BillReceivable billReceivable) {
		// TODO Auto-generated method stub
		return billingRepository.save(billReceivable);
	}

	@Override
	public BillReceivable findByBillNumber(String billNumber) {
		// TODO Auto-generated method stub
		return billingRepository.findByBillNumber(billNumber);
	}

}
