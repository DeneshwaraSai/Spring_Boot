package com.pharmacy.code.service;

import java.util.List;

import com.pharmacy.code.dto.SimpleCodeValue;
import com.pharmacy.code.entity.Supplier;

public interface SupplierService {
	public Supplier save(Supplier supplier);
	
	public Supplier update(Supplier supplier);
	
	public Supplier  findById(Integer id);
	
	public List<Supplier> findAll();
	
	public List<SimpleCodeValue> findSupplierCodeAndName();
}
