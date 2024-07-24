package com.pharmacy.code.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmacy.code.dto.SimpleCodeValue;
import com.pharmacy.code.entity.Supplier;
import com.pharmacy.code.repository.SupplierRepository;

import jakarta.persistence.EntityManager;

@Service
public class SupplierServiceImpl implements SupplierService {

	private SupplierRepository supplierRepository;

	private EntityManager entityManager;

	@Autowired
	SupplierServiceImpl(SupplierRepository supplierRepository, EntityManager entityManager) {
		this.supplierRepository = supplierRepository;
		this.entityManager = entityManager;
	}

	@Override
	public Supplier save(Supplier supplier) {
		// TODO Auto-generated method stub
		try {
			return supplierRepository.save(supplier);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Supplier update(Supplier supplier) {
		// TODO Auto-generated method stub 
		try {
			return supplierRepository.save(supplier);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Supplier findById(Integer id) {
		// TODO Auto-generated method stub
		try {
			return supplierRepository.findById(id).get();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public List<Supplier> findAll() {
		// TODO Auto-generated method stub
		try {
			return supplierRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SimpleCodeValue> findSupplierCodeAndName() {
		// TODO Auto-generated method stub
		try {
			 List<SimpleCodeValue> supplierCodevalue = entityManager.createNamedQuery("SupplierService.findSupplierCodeAndName")
						 .getResultList();
			System.out.println(supplierCodevalue.toString());
			return supplierCodevalue;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
