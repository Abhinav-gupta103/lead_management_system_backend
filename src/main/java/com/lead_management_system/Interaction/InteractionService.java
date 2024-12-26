package com.lead_management_system.Interaction;

import java.util.List;

public interface InteractionService {
    Interaction addInteraction(Interaction interaction, Long restaurantId);

    List<Interaction> getInteractionsByRestaurantId(Long restaurantId);

    List<Interaction> getAllInteractions();

    Interaction getInteractionById(Long id);

    Interaction updateInteraction(Long id, Interaction updatedInteraction);

    void deleteInteraction(Long id);
}