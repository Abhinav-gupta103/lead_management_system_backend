package com.lead_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lead_management_system.entities.Interaction;

import java.util.List;

public interface InteractionRepository extends JpaRepository<Interaction, Long> {

    List<Interaction> findByPointOfContactId(Long pointOfContactId);

}