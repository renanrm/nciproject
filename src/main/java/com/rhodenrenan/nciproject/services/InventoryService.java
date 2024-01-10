package com.rhodenrenan.nciproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rhodenrenan.nciproject.models.Inventory;
import com.rhodenrenan.nciproject.repositories.InventoryRepository;

@Service
public class InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;
	
	// Return list
	public List<Inventory> findAll(){
		return inventoryRepository.findAll();
	}
	
	// Update
	public void save(Inventory inventory) {
		inventoryRepository.save(inventory);
	}
	
	// Get by id
	public Optional<Inventory> findById(int id) {
		return inventoryRepository.findById(id);
	}

	// Delete by id
	public void delete(Integer id) {
		inventoryRepository.deleteById(id);
	}
	
}
