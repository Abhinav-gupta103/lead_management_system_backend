package com.lead_management_system.PointOfContact;

import java.util.List;

public interface PointOfContactService {
    PointOfContact addContact(PointOfContact contact, Long restaurantId);

    PointOfContact updateContact(Long id, PointOfContact contactDetails);

    List<PointOfContact> getAllContacts();

    List<PointOfContact> getContactsByRestaurantId(Long restaurantId);

    PointOfContact getContactById(Long id);

    void deleteContact(Long id);
}