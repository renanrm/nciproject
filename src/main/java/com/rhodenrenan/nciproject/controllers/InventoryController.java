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

import com.rhodenrenan.nciproject.models.Inventory;
import com.rhodenrenan.nciproject.services.InventoryService;
import com.rhodenrenan.nciproject.services.SuppliersService;

@Controller
public class InventoryController {
	
	@Autowired
	private InventoryService inventoryService;
	
	@Autowired
	private SuppliersService suppliersService;
	
	// Get all
	@PreAuthorize("hasAnyRole('ADMIN', 'SUPPLY-MNGR')")
	@GetMapping("inventory")
	public String findAll(Model model){
		model.addAttribute("inventory", inventoryService.findAll());
		model.addAttribute("suppliers", suppliersService.findAll());
		return "inventory";
	}	

	// Find by id
	@RequestMapping("inventory/findById")
	@ResponseBody
	public Optional<Inventory> findById(@RequestParam Integer id)
	{
		return inventoryService.findById(id);
	}	
	
	// Add
	@PostMapping(value="inventory/addNew")
	public String addNew(Inventory inventory) {
		inventoryService.save(inventory);
		return "redirect:/inventory";
	}	

	// Update
	@RequestMapping(value="inventory/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Inventory inventory) {
		inventoryService.save(inventory);
		return "redirect:/inventory";
	}
		
	// Delete
	@RequestMapping(value="inventory/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer id) {
		inventoryService.delete(id);
		return "redirect:/inventory";
	}
	
}