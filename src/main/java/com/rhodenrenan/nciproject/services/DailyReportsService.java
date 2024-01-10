package com.rhodenrenan.nciproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rhodenrenan.nciproject.models.DailyReports;
import com.rhodenrenan.nciproject.repositories.DailyReportsRepository;

@Service
public class DailyReportsService {

	@Autowired
	private DailyReportsRepository dailyReportsRepository;
	
	// Return list
	public List<DailyReports> findAll(){
		return dailyReportsRepository.findAll();
	}
	
	// Update
	public void save(DailyReports dailyReports) {
		dailyReportsRepository.save(dailyReports);
	}
	
	// Get by id
	public Optional<DailyReports> findById(int id) {
		return dailyReportsRepository.findById(id);
	}

	// Delete by id
	public void delete(Integer id) {
		dailyReportsRepository.deleteById(id);
	}
	
}
