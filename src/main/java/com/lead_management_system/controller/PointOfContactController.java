package com.lead_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lead_management_system.Service.PointOfContactService;
import com.lead_management_system.entities.PointOfContact;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class PointOfContactController {

    @Autowired
    private PointOfContactService contactService;

    @PostMapping("/{restaurantId}")
    public ResponseEntity<PointOfContact> addContact(
            @PathVariable Long restaurantId,
            @RequestBody PointOfContact contact) {
        return ResponseEntity.ok(contactService.addContact(contact, restaurantId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PointOfContact> updateContact(
            @PathVariable Long id,
            @RequestBody PointOfContact contactDetails) {
        return ResponseEntity.ok(contactService.updateContact(id, contactDetails));
    }

    @GetMapping
    public ResponseEntity<List<PointOfContact>> getAllContacts() {
        return ResponseEntity.ok(contactService.getAllContacts());
    }

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<PointOfContact>> getContactsByRestaurantId(
            @PathVariable Long restaurantId) {
        return ResponseEntity.ok(contactService.getContactsByRestaurantId(restaurantId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PointOfContact> getContactById(@PathVariable Long id) {
        return ResponseEntity.ok(contactService.getContactById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
        return ResponseEntity.noContent().build();
    }
}