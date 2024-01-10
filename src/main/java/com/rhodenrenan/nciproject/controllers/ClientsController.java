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

import com.rhodenrenan.nciproject.models.Clients;
import com.rhodenrenan.nciproject.services.ClientsService;

@Controller
public class ClientsController {
	
	@Autowired
	private ClientsService clientsService;
	
	// Get all
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("clients")
	public String findAll(Model model){		
		model.addAttribute("clients", clientsService.findAll());
		return "clients";
	}	

	// Find by id
	@RequestMapping("clients/findById")
	@ResponseBody
	public Optional<Clients> findById(@RequestParam Integer id)
	{
		return clientsService.findById(id);
	}	
	
	// Add
	@PostMapping(value="clients/addNew")
	public String addNew(Clients clients) {
		clientsService.save(clients);
		return "redirect:/clients";
	}	

	// Update
	@RequestMapping(value="clients/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Clients clients) {
		clientsService.save(clients);
		return "redirect:/clients";
	}
	
	// Delete
	@RequestMapping(value="clients/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer id) {
		clientsService.delete(id);
		return "redirect:/clients";
	}
	
}