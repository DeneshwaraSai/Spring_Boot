package com.pharmacy.code.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pharmacy.code.entity.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
	public Supplier save(Supplier supplier);
	
	public Optional<Supplier> findById(Integer id);
	
	public List<Supplier> findAll();
}
