package com.lead_management_system.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "interactions")
@Getter
@Setter
@NoArgsConstructor
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

}