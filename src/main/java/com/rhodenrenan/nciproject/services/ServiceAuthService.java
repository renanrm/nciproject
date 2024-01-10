package com.rhodenrenan.nciproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rhodenrenan.nciproject.models.ServiceAuth;
import com.rhodenrenan.nciproject.repositories.ServiceAuthRepository;

@Service
public class ServiceAuthService {

	@Autowired
	private ServiceAuthRepository serviceAuthRepository;
	
	// Return list
	public List<ServiceAuth> findAll(){
		return serviceAuthRepository.findAll();
	}
	
	// Update
	public void save(ServiceAuth serviceAuth) {
		serviceAuthRepository.save(serviceAuth);
	}
	
	// Get by id
	public Optional<ServiceAuth> findById(int id) {
		return serviceAuthRepository.findById(id);
	}

	// Delete by id
	public void delete(Integer id) {
		serviceAuthRepository.deleteById(id);
	}
	
}
