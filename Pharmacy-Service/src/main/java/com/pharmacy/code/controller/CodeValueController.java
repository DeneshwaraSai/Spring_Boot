package com.pharmacy.code.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pharmacy.code.dto.SimpleCodeValue;
import com.pharmacy.code.service.CodeValueService;

@RestController
@CrossOrigin
public class CodeValueController {

	private CodeValueService codeValueService;

	@Autowired
	public CodeValueController(CodeValueService codeValueService) {
		this.codeValueService = codeValueService;
	}

	@GetMapping(path = "/codeValue/list")
	public Map<String, List<SimpleCodeValue>> getCodeValues() {
		return codeValueService.findAllCodeValues();
	}
}
