package com.lead_management_system.Interaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interactions")
public class InteractionController {

    @Autowired
    private InteractionService interactionService;

    @PostMapping("/{restaurantId}")
    public ResponseEntity<Interaction> addInteraction(
            @PathVariable Long restaurantId,
            @RequestBody Interaction interaction) {
        return ResponseEntity.ok(interactionService.addInteraction(interaction, restaurantId));
    }

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<Interaction>> getInteractionsByRestaurantId(
            @PathVariable Long restaurantId) {
        return ResponseEntity.ok(interactionService.getInteractionsByRestaurantId(restaurantId));
    }

    @GetMapping
    public ResponseEntity<List<Interaction>> getAllInteractions() {
        return ResponseEntity.ok(interactionService.getAllInteractions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Interaction> getInteractionById(@PathVariable Long id) {
        return ResponseEntity.ok(interactionService.getInteractionById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Interaction> updateInteraction(@PathVariable Long id, @RequestBody Interaction interaction) {
        Interaction updatedInteraction = interactionService.updateInteraction(id, interaction);
        return ResponseEntity.ok(updatedInteraction);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInteraction(@PathVariable Long id) {
        interactionService.deleteInteraction(id);
        return ResponseEntity.noContent().build();
    }
}