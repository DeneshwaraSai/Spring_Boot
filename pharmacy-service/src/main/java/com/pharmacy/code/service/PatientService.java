package com.pharmacy.code.service;

import java.util.List;

import com.pharmacy.code.dto.PatientHeaderContext;
import com.pharmacy.code.dto.PatientSearchDto;
import com.pharmacy.code.entity.Patient;

public interface PatientService {
	public Patient save(Patient patient);

	public Patient findById(Integer id);
	
	public List<Patient> findAll();
	
	public List<PatientSearchDto> searchpatients(String value);
	
	public PatientHeaderContext findPatientByUhid(Integer uhid);
}
