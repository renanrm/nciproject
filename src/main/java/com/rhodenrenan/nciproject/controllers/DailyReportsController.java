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

import com.rhodenrenan.nciproject.models.DailyReports;
import com.rhodenrenan.nciproject.services.DailyReportsService;

@Controller
public class DailyReportsController {
	
	@Autowired
	private DailyReportsService dailyReportsService;	
	
	// Get all	
	@PreAuthorize("hasAnyRole('ADMIN', 'ADMIN-ASTT')")	
	@GetMapping("dailyreports")
	public String findAll(Model model){		
		model.addAttribute("dailyreports", dailyReportsService.findAll());
		return "dailyReports";
	}	

	// Find by id
	@RequestMapping("dailyreports/findById")
	@ResponseBody
	public Optional<DailyReports> findById(@RequestParam Integer id)
	{
		return dailyReportsService.findById(id);
	}	
	
	// Add
	@PostMapping(value="dailyreports/addNew")
	public String addNew(DailyReports dailyReports) {
		dailyReportsService.save(dailyReports);
		return "redirect:/dailyreports";
	}	

	// Update
	@RequestMapping(value="dailyreports/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(DailyReports dailyReports) {
		dailyReportsService.save(dailyReports);
		return "redirect:/dailyreports";
	}
	
	// Delete
	@RequestMapping(value="dailyreports/delete", method = {RequestMethod.DELETE, RequestMethod.GET})	
	public String delete(Integer id) {
		dailyReportsService.delete(id);
		return "redirect:/dailyreports";
	}
	
}