package com.pharmacy.code.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pharmacy.code.dto.DrugSetupDto;
import com.pharmacy.code.entity.DrugSetup;
import com.pharmacy.code.service.DrugSetupService;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
public class DrugSetupController {
	
	private DrugSetupService drugSetupService;
	 
	@Autowired
	public DrugSetupController(DrugSetupService drugSetupService) {
		this.drugSetupService = drugSetupService;
	}
	
	@GetMapping(path = "/drug/{id}")
	public DrugSetup findById(@PathVariable(name = "id", required = true) Integer id) {
		return drugSetupService.findById(id);
	}
	
	@PostMapping(path = "/drug/save")
	public DrugSetup save(@RequestBody @Valid DrugSetup drugSetup) {
		System.out.println(drugSetup.toString());
		return drugSetupService.save(drugSetup);
	}
	
	@PutMapping(path = "/drug/update")
	public DrugSetup update(@RequestBody DrugSetup drugSetup) {
		return drugSetupService.update(drugSetup);
	}
	
	@GetMapping(path = "/drug/all")
	public List<DrugSetupDto> findAll(@RequestParam(name = "name", defaultValue = "") String name) {
		return drugSetupService.findAllDrugByName(name);
	}
}
