package com.lead_management_system.Service.impl;

import org.springframework.stereotype.Service;

import com.lead_management_system.Service.InteractionService;
import com.lead_management_system.Service.PerformanceService;
import com.lead_management_system.Service.RestaurantLeadsService;
import com.lead_management_system.entities.Interaction;
import com.lead_management_system.entities.RestaurantLeads;
import com.lead_management_system.entities.dto.RestaurantPerformanceDTO;

import java.util.List;

@Service
public class PerformanceServiceImpl implements PerformanceService {
    private final RestaurantLeadsService restaurantLeadsService;
    private final InteractionService interactionsService;

    public PerformanceServiceImpl(RestaurantLeadsService restaurantLeadsService,
            InteractionService interactionsService) {
        this.restaurantLeadsService = restaurantLeadsService;
        this.interactionsService = interactionsService;
    }

    @Override
    public List<RestaurantPerformanceDTO> getRestaurantPerformance() {
        List<RestaurantLeads> restaurants = restaurantLeadsService.getAllLeads();

        return restaurants.stream()
                .map(this::mapToPerformanceDTO)
                .sorted((a, b) -> Long.compare(b.getTotalOrderPlaced(), a.getTotalOrderPlaced()))
                .toList();
    }

    @Override
    public RestaurantPerformanceDTO getPerformanceByRestaurantId(Long restaurantId) {
        RestaurantLeads restaurant = restaurantLeadsService.getLeadById(restaurantId);
        if (restaurant == null) {
            throw new IllegalArgumentException("Restaurant not found with ID: " + restaurantId);
        }

        return mapToPerformanceDTO(restaurant);
    }

    private RestaurantPerformanceDTO mapToPerformanceDTO(RestaurantLeads restaurant) {
        List<Interaction> interactions = interactionsService.getInteractionsByRestaurantId(restaurant.getId());

        long totalOrderPlaced = interactions.stream()
                .filter(Interaction::isOrderPlaced)
                .count();

        return new RestaurantPerformanceDTO(
                restaurant.getId(),
                restaurant.getName(),
                restaurant.getAddress(),
                restaurant.getLeadStatus(),
                restaurant.getCreatedAt(),
                restaurant.getUpdatedAt(),
                totalOrderPlaced);
    }
}