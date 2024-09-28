package com.pharmacy.code.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pharmacy.code.dto.SimpleCodeValue;
import com.pharmacy.code.entity.Supplier;
import com.pharmacy.code.service.SupplierService;

@CrossOrigin
@RestController
public class SupplierController {

	private SupplierService supplierService;

	@Autowired
	public SupplierController(SupplierService supplierService) {
		this.supplierService = supplierService;
	}

	@GetMapping(path = "/supplier/codeValue")
	public List<SimpleCodeValue> findSupplierCodeAndName() {
		try {
			return supplierService.findSupplierCodeAndName();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@GetMapping(path = "/supplier/supplier-list")
	public List<Supplier> findAllSuppliers() {
		try {
			return supplierService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@PostMapping(path = "/supplier/create")
	public Supplier save(@RequestBody Supplier supplier) {
		try {
			return supplierService.save(supplier);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@PutMapping(path = "/supplier/update")
	public Supplier update(@RequestBody Supplier supplier) {
		try {
			return supplierService.update(supplier);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@GetMapping(path = "/supplier/{id}")
	public Supplier findSupplierById(@PathVariable(name = "id", required =  true) Integer id) {
		try {
			return supplierService.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
