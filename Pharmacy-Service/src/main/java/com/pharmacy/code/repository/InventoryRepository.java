package com.pharmacy.code.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pharmacy.code.entity.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
	
	public Inventory save(Inventory inventory);
	
	public Optional<Inventory> findById(Integer id);
}
