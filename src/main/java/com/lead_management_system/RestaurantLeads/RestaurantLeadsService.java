package com.lead_management_system.RestaurantLeads;

import java.util.List;

public interface RestaurantLeadsService {
    RestaurantLeads addLead(RestaurantLeads lead);

    RestaurantLeads updateLead(Long id, RestaurantLeads leadDetails);

    List<RestaurantLeads> getAllLeads();

    RestaurantLeads getLeadById(Long id);

    void deleteLead(Long id);

    List<RestaurantLeads> getLeadsByStatus(LeadStatus status);
}