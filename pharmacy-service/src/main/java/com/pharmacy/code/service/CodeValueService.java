package com.pharmacy.code.service;

import java.util.List;
import java.util.Map;

import com.pharmacy.code.dto.SimpleCodeValue;
import com.pharmacy.code.entity.CodeValue;

public interface CodeValueService {

	public List<CodeValue> findAll();
	
	public Map<String, List<SimpleCodeValue>> findAllCodeValues();
}
