package com.lead_management_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lead_management_system.entities.RestaurantLeads;
import com.lead_management_system.entities.enums.LeadStatus;

public interface RestaurantLeadsRepository extends JpaRepository<RestaurantLeads, Long> {

    List<RestaurantLeads> findByLeadStatus(LeadStatus leadStatus);
}