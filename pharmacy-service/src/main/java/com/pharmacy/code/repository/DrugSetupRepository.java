package com.pharmacy.code.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pharmacy.code.entity.DrugSetup;

@Repository
public interface DrugSetupRepository extends JpaRepository<DrugSetup, Integer> {

	public DrugSetup save(DrugSetup drugSetup);

	public Optional<DrugSetup> findById(Integer id);
	
	public List<DrugSetup> findAll();
}
