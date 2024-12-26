package com.lead_management_system.RestaurantLeads;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lead_management_system.Interaction.Interaction;
import com.lead_management_system.PointOfContact.PointOfContact;

@Entity
@Table(name = "restaurant_leads")
public class RestaurantLeads {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LeadStatus leadStatus;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<PointOfContact> pointsOfContact;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Interaction> interactions;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public RestaurantLeads() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LeadStatus getLeadStatus() {
        return leadStatus;
    }

    public void setLeadStatus(LeadStatus leadStatus) {
        this.leadStatus = leadStatus;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<PointOfContact> getPointsOfContact() {
        return pointsOfContact;
    }

    public void setPointsOfContact(List<PointOfContact> pointsOfContact) {
        this.pointsOfContact = pointsOfContact;
    }

}