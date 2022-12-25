package com.marketingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketingapp.dto.LeadData;
import com.marketingapp.entities.Leads;
import com.marketingapp.services.LeadsServices;
import com.marketingapp.util.EmailService;

@Controller
public class LeadsController {
	
	@Autowired
	private LeadsServices leadsServices;

	@RequestMapping("CreateLeads")
	public String viewLeadPage() {
		return "create_leads";
	} 

	
	  @RequestMapping("/saveLead") 
	  public String saveLead(@ModelAttribute("leads") Leads l , ModelMap model) { 
	  leadsServices.saveLeadServices(l); 
//	  emailService.sendSimpleMail(l.getEmail(), "text", "body");
	  model.addAttribute("msg","New Leads Are Saved!!");
	  return "create_leads"; 
	  }
	  
	  @RequestMapping("/listall")
	  public String listAllLeads(ModelMap model) {
		  List<Leads> leads = leadsServices.listAllLeads();
		  model.addAttribute("leads", leads);
		  return "list_leads";
	  }
	 

	  @RequestMapping("/deleteLead")
	  public String deleteLead(@RequestParam("id") int id,ModelMap model) {
		  leadsServices.deleteLead(id);
		  List<Leads> leads = leadsServices.listAllLeads();
		  model.addAttribute("leads", leads);
		  return "list_leads";
	  }
	  
	  @RequestMapping("/updateLead")
	  public String updateLead(@RequestParam("id") int id, ModelMap model) {
		  Leads leads = leadsServices.updateLead(id);
		  model.addAttribute("leads", leads);
		  return "update_lead";
	  }
	  
	  @RequestMapping("/updateOneLead") 
	  public String updateOneLead(@ModelAttribute("leads") Leads l , ModelMap model) { 
	  leadsServices.saveLeadServices(l); 
	  List<Leads> leads = leadsServices.listAllLeads();
	  model.addAttribute("leads", leads);
	  return "list_leads";
	  }
	  
//	@RequestMapping("saveLead")
//	public String saveLead(@RequestParam("firstName") String fname, @RequestParam("lastName") String lname,
//			@RequestParam("email") String email, @RequestParam("mobile") String mobile) {
//
//		Leads leads = new Leads();
//		leads.setFirstName(fname);
//		leads.setLastName(lname);
//		leads.setEmail(email);
//		leads.setMobile(mobile);
//		
//		leadsServices.saveLeadServices(leads);
//		
//		return "create_leads";
//	}
	
	
	
//	@RequestMapping("saveLead") 
//		public String saveLead(LeadData data) { 
//		Leads l = new Leads();
//		l.setFirstName(data.getFirstName());
//		l.setLastName(data.getLastName());
//		l.setEmail(data.getEmail());
//		l.setMobile(data.getMobile());
//		leadsServices.saveLeadServices(l);
//		return "create_leads"; 
//	}
}
