package com.lead_management_system.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lead_management_system.Service.InteractionService;
import com.lead_management_system.Service.RestaurantLeadsService;
import com.lead_management_system.entities.Interaction;
import com.lead_management_system.entities.PointOfContact;
import com.lead_management_system.entities.RestaurantLeads;
import com.lead_management_system.repository.InteractionRepository;
import com.lead_management_system.repository.PointOfContactRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class InteractionServiceImpl implements InteractionService {

    @Autowired
    private InteractionRepository interactionRepository;

    @Autowired
    private PointOfContactRepository pointOfContactRepository;

    @Autowired
    private RestaurantLeadsService restaurantLeadsService;

    @Override
    public Interaction addInteraction(Interaction interaction, Long pointOfContactId) {
        PointOfContact pointOfContact = pointOfContactRepository.findById(
                pointOfContactId)
                .orElseThrow(() -> new RuntimeException("Point of contact not found with id: " + pointOfContactId));
        interaction.setPointOfContact(pointOfContact);
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
        RestaurantLeads restaurantLead = restaurantLeadsService.getLeadById(restaurantId);
        System.out.println(restaurantLead.getPointsOfContact());
        List<Interaction> interactions = new ArrayList<>();
        return interactions;
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

    @Override
    public List<Interaction> getInteractionsByPointOfContactId(Long pointOfContactId) {
        return interactionRepository.findByPointOfContactId(pointOfContactId);
    }
}