package com.lead_management_system.Performance;

import org.springframework.web.bind.annotation.*;

import com.lead_management_system.Performance.dto.RestaurantPerformanceDTO;

import java.util.List;

@RestController
@RequestMapping("/api/performance")
public class PerformanceController {
    private final PerformanceService performanceService;

    public PerformanceController(PerformanceService performanceService) {
        this.performanceService = performanceService;
    }

    @GetMapping
    public List<RestaurantPerformanceDTO> getPerformanceData() {
        return this.performanceService.getRestaurantPerformance();
    }

    @GetMapping("/{restaurantId}")
    public RestaurantPerformanceDTO getPerformanceByRestaurantId(@PathVariable Long restaurantId) {
        return this.performanceService.getPerformanceByRestaurantId(restaurantId);
    }
}