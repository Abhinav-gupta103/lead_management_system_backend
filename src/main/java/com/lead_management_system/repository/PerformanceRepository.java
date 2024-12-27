package com.lead_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lead_management_system.entities.Performance;

public interface PerformanceRepository extends JpaRepository<Performance, Long> {

    Performance findByRestaurantId(Long restaurantId);
}