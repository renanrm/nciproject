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

import com.rhodenrenan.nciproject.models.Suppliers;
import com.rhodenrenan.nciproject.services.SuppliersService;

@Controller
public class SuppliersController {
	
	@Autowired
	private SuppliersService suppliersService;
	
	// Get all	
	@PreAuthorize("hasAnyRole('ADMIN', 'SUPPLY-MNGR')")
	@GetMapping("suppliers")
	public String findAll(Model model){		
		model.addAttribute("suppliers", suppliersService.findAll());
		return "suppliers";
	}	

	// Find by id
	@RequestMapping("suppliers/findById")
	@ResponseBody
	public Optional<Suppliers> findById(@RequestParam Integer id)
	{
		return suppliersService.findById(id);
	}	
	
	// Add
	@PostMapping(value="suppliers/addNew")
	public String addNew(Suppliers suppliers) {
		suppliersService.save(suppliers);
		return "redirect:/suppliers";
	}	

	// Update
	@RequestMapping(value="suppliers/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Suppliers suppliers) {
		suppliersService.save(suppliers);
		return "redirect:/suppliers";
	}
	
	// Delete
	@RequestMapping(value="suppliers/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer id) {
		suppliersService.delete(id);
		return "redirect:/suppliers";
	}
	
}