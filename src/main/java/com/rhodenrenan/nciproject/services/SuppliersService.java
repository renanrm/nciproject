package com.rhodenrenan.nciproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rhodenrenan.nciproject.models.Suppliers;
import com.rhodenrenan.nciproject.repositories.SuppliersRepository;

@Service
public class SuppliersService {

	@Autowired
	private SuppliersRepository suppliersRepository;
	
	// Return list
	public List<Suppliers> findAll(){
		return suppliersRepository.findAll();
	}
	
	// Update
	public void save(Suppliers suppliers) {
		suppliersRepository.save(suppliers);
	}
	
	// Get by id
	public Optional<Suppliers> findById(int id) {
		return suppliersRepository.findById(id);
	}

	// Delete by id
	public void delete(Integer id) {
		suppliersRepository.deleteById(id);
	}
	
}
