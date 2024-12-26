package com.lead_management_system.PointOfContact.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lead_management_system.PointOfContact.PointOfContact;
import com.lead_management_system.PointOfContact.PointOfContactRepository;
import com.lead_management_system.PointOfContact.PointOfContactService;
import com.lead_management_system.RestaurantLeads.RestaurantLeads;
import com.lead_management_system.RestaurantLeads.RestaurantLeadsRepository;

import java.util.List;

@Service
public class PointOfContactServiceImpl implements PointOfContactService {

    @Autowired
    private PointOfContactRepository contactRepository;

    @Autowired
    private RestaurantLeadsRepository leadsRepository;

    @Override
    public PointOfContact addContact(PointOfContact contact, Long restaurantId) {
        RestaurantLeads restaurant = leadsRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("Restaurant not found with id: " + restaurantId));
        contact.setRestaurant(restaurant);
        return contactRepository.save(contact);
    }

    @Override
    public PointOfContact updateContact(Long id, PointOfContact contactDetails) {
        PointOfContact contact = contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact not found with id: " + id));

        contact.setName(contactDetails.getName());
        contact.setRole(contactDetails.getRole());
        contact.setContactInfo(contactDetails.getContactInfo());
        return contactRepository.save(contact);
    }

    @Override
    public List<PointOfContact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public List<PointOfContact> getContactsByRestaurantId(Long restaurantId) {
        return contactRepository.findByRestaurantId(restaurantId);
    }

    @Override
    public PointOfContact getContactById(Long id) {
        return contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact not found with id: " + id));
    }

    @Override
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }
}