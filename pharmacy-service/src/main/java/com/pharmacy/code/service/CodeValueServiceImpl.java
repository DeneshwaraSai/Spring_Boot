package com.pharmacy.code.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.pharmacy.code.dto.SimpleCodeValue;
import com.pharmacy.code.entity.CodeValue;
import com.pharmacy.code.repository.CodeValueRepository;

@Service
public class CodeValueServiceImpl implements CodeValueService {

	private CodeValueRepository codeValueRepository;

	@Autowired
	public CodeValueServiceImpl(CodeValueRepository codeValueRepository) {
		this.codeValueRepository = codeValueRepository;
	}

	@Override
	public List<CodeValue> findAll() {
		// TODO Auto-generated method stub
		return codeValueRepository.findAll();
	}

	@Override
	public Map<String, List<SimpleCodeValue>> findAllCodeValues() {
		// TODO Auto-generated method stub

		List<CodeValue> codeValueList = codeValueRepository.findAll();

		Map<String, List<SimpleCodeValue>> codeValueMap = new HashMap<String, List<SimpleCodeValue>>();

		codeValueMap = codeValueList.stream()
				.collect(Collectors.groupingBy( CodeValue::getDomainName, 
				Collectors.mapping(codeValue -> new SimpleCodeValue(codeValue.getCode(), codeValue.getValue()), 
				Collectors.toList() ) ));
		
		System.out.println(codeValueMap.toString());
		
		return codeValueMap;	
	}

}
