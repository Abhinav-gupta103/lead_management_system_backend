package com.lead_management_system.RestaurantLeads.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lead_management_system.RestaurantLeads.LeadStatus;
import com.lead_management_system.RestaurantLeads.RestaurantLeads;
import com.lead_management_system.RestaurantLeads.RestaurantLeadsRepository;
import com.lead_management_system.RestaurantLeads.RestaurantLeadsService;

@Service
public class RestaurantLeadsServiceImpl implements RestaurantLeadsService {

    @Autowired
    private RestaurantLeadsRepository leadsRepository;

    @Override
    public RestaurantLeads addLead(RestaurantLeads lead) {
        return leadsRepository.save(lead);
    }

    @Override
    public RestaurantLeads updateLead(Long id, RestaurantLeads leadDetails) {
        Optional<RestaurantLeads> leadOpt = leadsRepository.findById(id);
        if (leadOpt.isPresent()) {
            RestaurantLeads lead = leadOpt.get();
            lead.setName(leadDetails.getName());
            lead.setAddress(leadDetails.getAddress());
            lead.setLeadStatus(leadDetails.getLeadStatus());
            return leadsRepository.save(lead);
        } else {
            throw new RuntimeException("Lead not found with id: " + id);
        }
    }

    @Override
    public List<RestaurantLeads> getAllLeads() {
        return leadsRepository.findAll();
    }

    @Override
    public RestaurantLeads getLeadById(Long id) {
        return leadsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lead not found with id: " + id));
    }

    @Override
    public void deleteLead(Long id) {
        leadsRepository.deleteById(id);
    }

    @Override
    public List<RestaurantLeads> getLeadsByStatus(LeadStatus status) {
        return leadsRepository.findByLeadStatus(status);
    }
}