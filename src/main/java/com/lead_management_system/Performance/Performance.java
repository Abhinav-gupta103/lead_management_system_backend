package com.lead_management_system.Performance;

import com.lead_management_system.RestaurantLeads.RestaurantLeads;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "account_performance")
public class Performance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private RestaurantLeads restaurant;

    @Column(nullable = false)
    private int totalOrders;

    @Column(nullable = false)
    private double averageOrderValue;

    @Column(nullable = false)
    private boolean isWellPerforming;

    public Performance() {
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

    public int getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(int totalOrders) {
        this.totalOrders = totalOrders;
    }

    public double getAverageOrderValue() {
        return averageOrderValue;
    }

    public void setAverageOrderValue(double averageOrderValue) {
        this.averageOrderValue = averageOrderValue;
    }

    public boolean isWellPerforming() {
        return isWellPerforming;
    }

    public void setWellPerforming(boolean isWellPerforming) {
        this.isWellPerforming = isWellPerforming;
    }

}