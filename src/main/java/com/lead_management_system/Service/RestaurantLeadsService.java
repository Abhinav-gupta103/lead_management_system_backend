package com.lead_management_system.Service;

import java.util.List;

import com.lead_management_system.entities.RestaurantLeads;
import com.lead_management_system.entities.enums.LeadStatus;

public interface RestaurantLeadsService {
    RestaurantLeads addLead(RestaurantLeads lead);

    RestaurantLeads updateLead(Long id, RestaurantLeads leadDetails);

    List<RestaurantLeads> getAllLeads();

    RestaurantLeads getLeadById(Long id);

    void deleteLead(Long id);

    List<RestaurantLeads> getLeadsByStatus(LeadStatus status);
}