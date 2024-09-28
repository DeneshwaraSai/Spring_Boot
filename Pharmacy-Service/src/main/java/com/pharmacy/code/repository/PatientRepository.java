package com.pharmacy.code.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pharmacy.code.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

	public Patient save(Patient patient);

	public Optional<Patient> findById(Integer id);
	
	public List<Patient> findAll();
}
