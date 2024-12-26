package com.lead_management_system.Performance;

import java.util.List;

import com.lead_management_system.Performance.dto.RestaurantPerformanceDTO;

public interface PerformanceService {
    List<RestaurantPerformanceDTO> getRestaurantPerformance();

    RestaurantPerformanceDTO getPerformanceByRestaurantId(Long restaurantId);
}