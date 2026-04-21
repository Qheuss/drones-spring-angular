package com.drones.spring1.services;

import com.drones.spring1.entities.Battery;
import com.drones.spring1.repositories.BatteryRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BatteryService {

  private final BatteryRepository repository;

  public List<Battery> findAll() {
    return repository.findAll();
  }

  public Optional<Battery> findById(Long id) {
    return repository.findById(id);
  }

  public void addBattery(Battery battery) {
    repository.save(battery);
  }

  public void deleteById(Long id) {
    repository.deleteById(id);
  }
}
