package com.lead_management_system.RestaurantLeads;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantLeadsRepository extends JpaRepository<RestaurantLeads, Long> {

    List<RestaurantLeads> findByLeadStatus(LeadStatus leadStatus);
}