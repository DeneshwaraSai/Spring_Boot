package com.pharmacy.code.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmacy.code.entity.TaxCategory;
import com.pharmacy.code.repository.TaxCategoryRepository;

@Service
public class TaxCategoryServiceImpl implements TaxCategoryService {
	
	TaxCategoryRepository taxCategoryRepository;
	
	@Autowired
	public TaxCategoryServiceImpl(TaxCategoryRepository taxCategoryRepository) {
		this.taxCategoryRepository = taxCategoryRepository;
	}
	
	@Override
	public List<TaxCategory> findAll() {
		// TODO Auto-generated method stub
		return taxCategoryRepository.findAll();
	}

}
