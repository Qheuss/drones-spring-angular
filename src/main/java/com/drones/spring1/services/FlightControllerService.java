package com.drones.spring1.services;

import com.drones.spring1.entities.FlightController;
import com.drones.spring1.repositories.FlightControllerRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FlightControllerService {

  private final FlightControllerRepository repository;

  public List<FlightController> findAll() {
    return repository.findAll();
  }

  public Optional<FlightController> findById(Long id) {
    return repository.findById(id);
  }

  public void addFlightController(FlightController flightController) {
    repository.save(flightController);
  }

  public void deleteById(Long id) {
    repository.deleteById(id);
  }
}
