package com.lead_management_system.Service;

import java.util.List;

import com.lead_management_system.entities.Interaction;

public interface InteractionService {
    Interaction addInteraction(Interaction interaction, Long restaurantId);

    List<Interaction> getInteractionsByRestaurantId(Long restaurantId);

    List<Interaction> getAllInteractions();

    Interaction getInteractionById(Long id);

    Interaction updateInteraction(Long id, Interaction updatedInteraction);

    void deleteInteraction(Long id);

    List<Interaction> getInteractionsByPointOfContactId(Long pointOfContactId);
}