package com.lead_management_system.Performance.dto;

import java.time.LocalDateTime;

import com.lead_management_system.RestaurantLeads.LeadStatus;

public class RestaurantPerformanceDTO {
    private Long id;
    private String name;
    private String address;
    private LeadStatus leadStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private long totalOrderPlaced;

    public RestaurantPerformanceDTO(Long id, String name, String address, LeadStatus leadStatus,
            LocalDateTime createdAt,
            LocalDateTime updatedAt, long totalOrderPlaced) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.leadStatus = leadStatus;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.totalOrderPlaced = totalOrderPlaced;
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

    public long getTotalOrderPlaced() {
        return totalOrderPlaced;
    }

    public void setTotalOrderPlaced(long totalOrderPlaced) {
        this.totalOrderPlaced = totalOrderPlaced;
    }

}
