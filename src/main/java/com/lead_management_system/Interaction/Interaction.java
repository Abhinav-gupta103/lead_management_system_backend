package com.lead_management_system.Interaction;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lead_management_system.RestaurantLeads.RestaurantLeads;

@Entity
@Table(name = "interactions")
public class Interaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @JsonIgnore
    private RestaurantLeads restaurant;

    @Column(nullable = false)
    private String interactionType;

    @Column(nullable = false)
    private LocalDateTime interactionDate;

    @Column(nullable = false)
    private boolean orderPlaced;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String details;

    public Interaction() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RestaurantLeads getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(RestaurantLeads restaurant) {
        this.restaurant = restaurant;
    }

    public String getInteractionType() {
        return interactionType;
    }

    public void setInteractionType(String interactionType) {
        this.interactionType = interactionType;
    }

    public LocalDateTime getInteractionDate() {
        return interactionDate;
    }

    public void setInteractionDate(LocalDateTime interactionDate) {
        this.interactionDate = interactionDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public boolean isOrderPlaced() {
        return orderPlaced;
    }

    public void setOrderPlaced(boolean orderPlaced) {
        this.orderPlaced = orderPlaced;
    }
}