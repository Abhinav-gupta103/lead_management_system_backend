package com.lead_management_system.PointOfContact;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lead_management_system.RestaurantLeads.RestaurantLeads;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "points_of_contact")
@Getter
@Setter
@NoArgsConstructor
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

}