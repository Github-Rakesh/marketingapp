package com.marketingapp.services;

import java.util.List;

import com.marketingapp.entities.Leads;

public interface LeadsServices {
	public void saveLeadServices(Leads l);

	public List<Leads> listAllLeads();

	public void deleteLead(int id);

	public Leads updateLead(int id);
}
