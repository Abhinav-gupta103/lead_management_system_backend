package com.lead_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lead_management_system.Service.RestaurantLeadsService;
import com.lead_management_system.entities.Interaction;
import com.lead_management_system.entities.RestaurantLeads;
import com.lead_management_system.entities.enums.LeadStatus;

@RestController
@RequestMapping("/api/leads")
@CrossOrigin(origins = "http://localhost:3000")
public class RestaurantLeadsController {

    @Autowired
    private RestaurantLeadsService leadsService;

    @PostMapping
    public ResponseEntity<RestaurantLeads> addLead(@RequestBody RestaurantLeads lead) {
        return ResponseEntity.ok(leadsService.addLead(lead));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestaurantLeads> updateLead(@PathVariable Long id, @RequestBody RestaurantLeads leadDetails) {
        return ResponseEntity.ok(leadsService.updateLead(id, leadDetails));
    }

    @GetMapping
    public ResponseEntity<List<RestaurantLeads>> getAllLeads() {
        return ResponseEntity.ok(leadsService.getAllLeads());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantLeads> getLeadById(@PathVariable Long id) {
        return ResponseEntity.ok(leadsService.getLeadById(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Interaction>> getInteractionsOfLeadById(@PathVariable Long id) {
        return ResponseEntity.ok(leadsService.getInteractionsOfLeadById(id));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLead(@PathVariable Long id) {
        leadsService.deleteLead(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<RestaurantLeads>> getLeadsByStatus(@PathVariable LeadStatus status) {
        return ResponseEntity.ok(leadsService.getLeadsByStatus(status));
    }
}