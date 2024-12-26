package com.lead_management_system.Performance;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformanceRepository extends JpaRepository<Performance, Long> {

    Performance findByRestaurantId(Long restaurantId);
}