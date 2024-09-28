package com.pharmacy.code.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmacy.code.dto.InventoryDashboard;
import com.pharmacy.code.dto.InventorySearchDto;
import com.pharmacy.code.entity.Inventory;
import com.pharmacy.code.repository.InventoryRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.apache.commons.lang3.StringUtils;

@Service
@Transactional
public class InventoryServiceImpl implements InventoryService {

	private InventoryRepository inventoryRepository;

	private EntityManager entityManager;

	@Autowired
	public InventoryServiceImpl(InventoryRepository inventoryRepository, EntityManager entityManager) {
		this.inventoryRepository = inventoryRepository;
		this.entityManager = entityManager;
	}

	@Override
	public Inventory save(@Valid Inventory inventory) {
		// TODO Auto-generated method stub

		List<Inventory> inventoryList = inventoryRepository.findAll();
		Integer size = inventoryList.size() + 1;
		inventory.setInventoryNumber(String.valueOf(size));		
		inventory.setCreatedBy("SysAdmin");
		inventory.setCreatedDate(new Date());
		if (inventory.getStatus() == null) {
			inventory.setStatus("P");
		}
		return inventoryRepository.save(inventory);
	}

	@Override
	public Inventory update(Inventory inventory) {
		// TODO Auto-generated method stub
		return inventoryRepository.save(inventory);
	}

	@Override
	public Inventory findById(Integer id) {
		// TODO Auto-generated method stub
		Inventory inventory = inventoryRepository.findById(id).get();
		inventory.getInventoryDetails().forEach(item -> {
			System.out.println("Code : " + item.getDrugCode() + " | Name : " + item.getDrugName());
		});
		return inventoryRepository.findById(id).get();
	}

	@Override
	public List<Inventory> findAll() {
		// TODO Auto-generated method stub
		return inventoryRepository.findAll();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<InventoryDashboard> getInventoryDashboard() {
		// TODO Auto-generated method stub
		List<InventoryDashboard> dashboardList = entityManager.createNamedQuery("InventoryService.getInventoryDashboard")
															  .getResultList();
		return dashboardList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<InventorySearchDto> getSearchedInventoryOrder(String name) {
		// TODO Auto-generated method stub
		try {
			List<InventorySearchDto> searchedData = entityManager.createNamedQuery("InventoryService.getSearchedInventoryOrder")
					.setParameter("name", StringUtils.isNotBlank(name) ? name : "")
					.getResultList();
			return searchedData;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Integer updateInventoryByIdAndStatus(Integer id, String status) {
		// TODO Auto-generated method stube
		
		Integer updated = entityManager.createNamedQuery("InventoryService.updateInventoryByIdAndStatus")
									   .setParameter("id", id)
									   .setParameter("status", status)
									   .executeUpdate();
										
		System.out.println(updated);
		return updated;
	}
}
