package com.lead_management_system.Performance.dto;

import java.time.LocalDateTime;

import com.lead_management_system.RestaurantLeads.LeadStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
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

}
