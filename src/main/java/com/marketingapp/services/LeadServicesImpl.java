package com.marketingapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketingapp.entities.Leads;
import com.marketingapp.repository.LeadsRepository;

@Service
public class LeadServicesImpl implements LeadsServices {
	
	@Autowired
	private LeadsRepository leadsRepo;

	@Override
	public void saveLeadServices(Leads l) {
		leadsRepo.save(l);
	}

	@Override
	public List<Leads> listAllLeads() {
		List<Leads> leads = leadsRepo.findAll();
		return leads;
	}

	@Override
	public void deleteLead(int id) {
		leadsRepo.deleteById(id);
	}

	@Override
	public Leads updateLead(int id) {
		Optional<Leads> findById = leadsRepo.findById(id);
		Leads leads = findById.get();
		return leads;
	}


}
