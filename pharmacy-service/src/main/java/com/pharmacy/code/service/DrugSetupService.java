package com.pharmacy.code.service;

import java.util.List;

import com.pharmacy.code.dto.DrugSetupDto;
import com.pharmacy.code.entity.DrugSetup;

public interface DrugSetupService {

	public DrugSetup save(DrugSetup drugSetup);
	
	public DrugSetup update(DrugSetup drugSetup);

	public DrugSetup findById(Integer id);
	
	public List<DrugSetup> findAll();
	
	List<DrugSetupDto> findAllDrugByName(String name);
}
