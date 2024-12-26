package com.lead_management_system.PointOfContact;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PointOfContactRepository extends JpaRepository<PointOfContact, Long> {

    List<PointOfContact> findByRestaurantId(Long restaurantId);
}