package com.rhodenrenan.nciproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rhodenrenan.nciproject.models.Contacts;
import com.rhodenrenan.nciproject.repositories.ContactsRepository;

@Service
public class ContactsService {

	@Autowired
	private ContactsRepository contactsRepository;
	
	// Return list
	public List<Contacts> findAll(){
		return contactsRepository.findAll();
	}
	
	// Update
	public void save(Contacts contacts) {
		contactsRepository.save(contacts);
	}
	
	// Get by id
	public Optional<Contacts> findById(int id) {
		return contactsRepository.findById(id);
	}

	// Delete by id
	public void delete(Integer id) {
		contactsRepository.deleteById(id);
	}
	
}
