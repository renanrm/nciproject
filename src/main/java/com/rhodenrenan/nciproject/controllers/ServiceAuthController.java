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

import com.rhodenrenan.nciproject.models.ServiceAuth;
import com.rhodenrenan.nciproject.services.ServiceAuthService;
 
@Controller
public class ServiceAuthController {
	
	@Autowired
	private ServiceAuthService serviceAuthService;

	// Get all
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("serviceauthorizations")
	public String findAll(Model model){		
		model.addAttribute("serviceauthorizations", serviceAuthService.findAll());
		return "serviceAuth";
	}	

	// Find by id
	@RequestMapping("serviceauthorizations/findById")
	@ResponseBody
	public Optional<ServiceAuth> findById(@RequestParam Integer id)
	{
		return serviceAuthService.findById(id);
	}	
	
	// Add
	@PostMapping(value="serviceauthorizations/addNew")
	public String addNew(ServiceAuth serviceAuth) {
		serviceAuthService.save(serviceAuth);
		return "redirect:/serviceauthorizations";
	}	
	
	// Update
	@RequestMapping(value="serviceauthorizations/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(ServiceAuth serviceAuth) {
		serviceAuthService.save(serviceAuth);
		return "redirect:/serviceauthorizations";
	}
	
	// Delete
	@RequestMapping(value="serviceauthorizations/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer id) {
		serviceAuthService.delete(id);
		return "redirect:/serviceauthorizations";
	}
	
}