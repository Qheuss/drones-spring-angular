package com.drones.back.repositories;

import com.drones.back.entities.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DroneRepository extends JpaRepository<Drone, Long> {
  //Requetes perso spécifiques
}
