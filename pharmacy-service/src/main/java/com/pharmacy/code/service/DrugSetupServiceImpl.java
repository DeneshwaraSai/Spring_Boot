package com.pharmacy.code.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.pharmacy.code.dto.DrugSetupDto;
import com.pharmacy.code.dto.ExceptionResponse;
import com.pharmacy.code.entity.DrugSetup;
import com.pharmacy.code.exception.ApplicationException;
import com.pharmacy.code.repository.DrugSetupRepository;

import jakarta.persistence.EntityManager;

@Service
public class DrugSetupServiceImpl implements DrugSetupService {

	private DrugSetupRepository drugSetupRepository;

	private EntityManager entityManager;

	@Autowired
	public DrugSetupServiceImpl(DrugSetupRepository drugSetupRepository, EntityManager entityManager) {
		this.drugSetupRepository = drugSetupRepository;
		this.entityManager = entityManager;
	}

	@Override
	public DrugSetup save(DrugSetup drugSetup) {
		// TODO Auto-generated method stub

		try {
			return drugSetupRepository.save(drugSetup);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public DrugSetup findById(Integer id) {
		// TODO Auto-generated method stub
		try {
			Optional<DrugSetup> drugSetup = drugSetupRepository.findById(id);
			if (drugSetup.isEmpty())  
				return null;

			return drugSetup.get();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public DrugSetup update(DrugSetup drugSetup) {
		// TODO Auto-generated method stub
		try {
			return drugSetupRepository.save(drugSetup);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<DrugSetup> findAll() {
		// TODO Auto-generated method stub
		try {
			return drugSetupRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DrugSetupDto> findAllDrugByName(String name) {
		// TODO Auto-generated method stub
	  try {
			List<DrugSetupDto> drugList = entityManager.createNamedQuery("DrugSetupService.findAllDrugByName")
					.setParameter("name", name)
					.getResultList();

			System.out.println(drugList.toString());
			
			return drugList;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
	}

	@ExceptionHandler
	public ResponseEntity<ExceptionResponse> handleException (ApplicationException exception) {

		ExceptionResponse response = new ExceptionResponse();

		response.setMessage(exception.getMessage());
		response.setTimestamp(System.currentTimeMillis());
		response.setStatus(HttpStatus.NOT_FOUND.value());

		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
}
