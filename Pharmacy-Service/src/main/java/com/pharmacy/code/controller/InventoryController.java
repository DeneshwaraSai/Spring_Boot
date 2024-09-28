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

import com.pharmacy.code.dto.InventoryDashboard;
import com.pharmacy.code.dto.InventorySearchDto;
import com.pharmacy.code.entity.Inventory;
import com.pharmacy.code.entity.OrderInfo;
import com.pharmacy.code.service.InventoryService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin
public class InventoryController {

	private InventoryService inventoryService;

	@Autowired
	public InventoryController(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}

	@PostMapping("/inventory/create")
	public Inventory save(@RequestBody Inventory inventory) {
		return inventoryService.save(inventory);
	}

	@PutMapping("/inventory/update")
	public Inventory update(@RequestBody Inventory inventory) {
		return inventoryService.update(inventory);
	}

	@GetMapping("/inventory/{id}")
	public Inventory findById(@PathVariable(name = "id", required = true) Integer id) {
		return inventoryService.findById(id);
	}

	@GetMapping("/inventory/all")
	public List<Inventory> findAll() {
		return inventoryService.findAll();
	}

	@GetMapping("/inventory/dashboard")
	public  List<InventoryDashboard> getInventoryDashboard(){
		return inventoryService.getInventoryDashboard();
	}

	@GetMapping("/inventory/order/search/{name}")
	public  List<InventorySearchDto> getSearchedInventoryOrder(@PathVariable(name= "name", required = true) String name) {
		return inventoryService.getSearchedInventoryOrder(name);
	}
	
	
	@PutMapping("/inventory/{id}/status/{status}")
	public Integer updateByIdAndStatus( @PathVariable(name = "id") Integer id,  @PathVariable(name = "status") String status) {
		return inventoryService.updateInventoryByIdAndStatus(id, status);
	}
}
