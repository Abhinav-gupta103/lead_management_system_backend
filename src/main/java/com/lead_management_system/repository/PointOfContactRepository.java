package com.lead_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lead_management_system.entities.PointOfContact;

import java.util.List;

public interface PointOfContactRepository extends JpaRepository<PointOfContact, Long> {

    List<PointOfContact> findByRestaurantId(Long restaurantId);
}