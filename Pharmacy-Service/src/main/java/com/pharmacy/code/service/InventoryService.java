package com.pharmacy.code.service;

import java.util.List;

import com.pharmacy.code.dto.InventoryDashboard;
import com.pharmacy.code.dto.InventorySearchDto;
import com.pharmacy.code.entity.Inventory;

public interface InventoryService {

	public Inventory save(Inventory inventory);
	
	public Inventory update(Inventory inventory);

	public Inventory findById(Integer id);
	
	public List<Inventory> findAll();
	
	public List<InventoryDashboard> getInventoryDashboard();
	
	public List<InventorySearchDto> getSearchedInventoryOrder(String name);
	
	public Integer updateInventoryByIdAndStatus(Integer id, String status);
}
