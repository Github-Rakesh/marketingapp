package com.marketingapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketingapp.entities.Leads;
import com.marketingapp.repository.LeadsRepository;

@RestController
@RequestMapping("/api/leads")
public class LeadsRestController {
	
	@Autowired
	private LeadsRepository leadsRepo;
	
	@GetMapping
	public List<Leads> getAllLeads(){
		List<Leads> leads = leadsRepo.findAll();
		return leads;
	}
	
	@PostMapping
	public void saveLeads(@RequestBody Leads lead) {
		leadsRepo.save(lead);
	}
	
	@PutMapping
	public void updateLeads(@RequestBody Leads lead) {
		leadsRepo.save(lead);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteLead(@PathVariable("id") int id) {
		leadsRepo.deleteById(id);
	}
	
	@RequestMapping("/lead/{id}")
	public Leads getOneLead(@PathVariable("id") int id) {
		Optional<Leads> findById = leadsRepo.findById(id);
		Leads leads = findById.get();
		return leads;
	}
}
