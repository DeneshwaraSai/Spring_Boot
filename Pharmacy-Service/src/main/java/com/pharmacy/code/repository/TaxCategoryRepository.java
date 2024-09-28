package com.pharmacy.code.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pharmacy.code.entity.TaxCategory;

@Repository
public interface TaxCategoryRepository extends JpaRepository<TaxCategory, Integer> {
	
	public List<TaxCategory> findAll();
}
