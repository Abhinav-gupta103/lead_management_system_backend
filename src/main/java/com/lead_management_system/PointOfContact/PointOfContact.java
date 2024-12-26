package com.lead_management_system.PointOfContact;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lead_management_system.RestaurantLeads.RestaurantLeads;

import jakarta.persistence.*;

@Entity
@Table(name = "points_of_contact")
public class PointOfContact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private String contactInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @JsonIgnore
    private RestaurantLeads restaurant;

    public PointOfContact() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public RestaurantLeads getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(RestaurantLeads restaurant) {
        this.restaurant = restaurant;
    }
}