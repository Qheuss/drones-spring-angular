package com.drones.spring1.repositories;

import com.drones.spring1.entities.FlightController;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightControllerRepository
  extends JpaRepository<FlightController, Long> {}
