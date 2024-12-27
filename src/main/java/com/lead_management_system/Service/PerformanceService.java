package com.lead_management_system.Service;

import java.util.List;

import com.lead_management_system.entities.dto.RestaurantPerformanceDTO;

public interface PerformanceService {
    List<RestaurantPerformanceDTO> getRestaurantPerformance();

    RestaurantPerformanceDTO getPerformanceByRestaurantId(Long restaurantId);
}