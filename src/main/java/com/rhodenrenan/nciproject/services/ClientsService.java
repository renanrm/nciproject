package com.rhodenrenan.nciproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rhodenrenan.nciproject.models.Clients;
import com.rhodenrenan.nciproject.repositories.ClientsRepository;

@Service
public class ClientsService {

	@Autowired
	private ClientsRepository clientsRepository;
	
	// Return list
	public List<Clients> findAll(){
		return clientsRepository.findAll();
	}
	
	// Update
	public void save(Clients clients) {
		clientsRepository.save(clients);
	}
	
	// Get by id
	public Optional<Clients> findById(int id) {
		return clientsRepository.findById(id);
	}

	// Delete by id
	public void delete(Integer id) {
		clientsRepository.deleteById(id);
	}
	
}
