package com.lead_management_system.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lead_management_system.Service.InteractionService;
import com.lead_management_system.entities.Interaction;
import com.lead_management_system.entities.RestaurantLeads;
import com.lead_management_system.repository.InteractionRepository;
import com.lead_management_system.repository.RestaurantLeadsRepository;

import java.util.List;

@Service
public class InteractionServiceImpl implements InteractionService {

    @Autowired
    private InteractionRepository interactionRepository;

    @Autowired
    private RestaurantLeadsRepository leadsRepository;

    @Override
    public Interaction addInteraction(Interaction interaction, Long restaurantId) {
        RestaurantLeads restaurant = leadsRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("Restaurant not found with id: " + restaurantId));
        interaction.setRestaurant(restaurant);
        return interactionRepository.save(interaction);
    }

    public Interaction updateInteraction(Long id, Interaction updatedInteraction) {
        Interaction interaction = interactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Interaction not found"));
        interaction.setInteractionDate(updatedInteraction.getInteractionDate());
        interaction.setDetails(updatedInteraction.getDetails());
        interaction.setOrderPlaced(updatedInteraction.isOrderPlaced());
        return interactionRepository.save(interaction);
    }

    @Override
    public List<Interaction> getInteractionsByRestaurantId(Long restaurantId) {
        return interactionRepository.findByRestaurantId(restaurantId);
    }

    @Override
    public List<Interaction> getAllInteractions() {
        return interactionRepository.findAll();
    }

    @Override
    public Interaction getInteractionById(Long id) {
        return interactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Interaction not found with id: " + id));
    }

    @Override
    public void deleteInteraction(Long id) {
        interactionRepository.deleteById(id);
    }
}