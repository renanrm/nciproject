package com.rhodenrenan.nciproject.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rhodenrenan.nciproject.models.Contacts;
import com.rhodenrenan.nciproject.services.ContactsService;

@Controller
public class ContactsController {
	
	@Autowired
	private ContactsService contactsService;
	
	// Get all	
	@PreAuthorize("hasAnyRole('ADMIN', 'ADMIN-ASTT', 'SUPPLY-MNGR')")
	@GetMapping("contacts")
	public String findAll(Model model){		
		model.addAttribute("contacts", contactsService.findAll());
		return "contacts";
	}	

	// Find by id
	@RequestMapping("contacts/findById")
	@ResponseBody
	public Optional<Contacts> findById(@RequestParam Integer id)
	{
		return contactsService.findById(id);
	}	
	
	// Add
	@PostMapping(value="contacts/addNew")
	public String addNew(Contacts contacts) {
		contactsService.save(contacts);
		return "redirect:/contacts";
	}	

	// Update
	@RequestMapping(value="contacts/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Contacts contacts) {
		contactsService.save(contacts);
		return "redirect:/contacts";
	}
	
	// Delete
	@RequestMapping(value="contacts/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer id) {
		contactsService.delete(id);
		return "redirect:/contacts";
	}
	
}