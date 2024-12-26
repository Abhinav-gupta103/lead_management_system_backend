package com.lead_management_system.Interaction;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InteractionRepository extends JpaRepository<Interaction, Long> {

    List<Interaction> findByRestaurantId(Long restaurantId);
}