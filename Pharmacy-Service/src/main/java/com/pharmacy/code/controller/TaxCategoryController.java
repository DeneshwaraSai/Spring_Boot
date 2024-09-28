package com.pharmacy.code.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pharmacy.code.entity.TaxCategory;
import com.pharmacy.code.service.TaxCategoryService;

@CrossOrigin
@RestController
public class TaxCategoryController {
	
	TaxCategoryService taxCategoryService;
	
	@Autowired
	public TaxCategoryController( TaxCategoryService taxCategoryService ) {
		this.taxCategoryService = taxCategoryService;
	}
	
	@GetMapping(path = "/taxCategory/list")
	public List<TaxCategory> findAll() {
		return taxCategoryService.findAll();
	}
	
}
