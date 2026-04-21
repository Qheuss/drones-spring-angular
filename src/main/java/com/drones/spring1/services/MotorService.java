package com.drones.spring1.services;

import com.drones.spring1.entities.Motor;
import com.drones.spring1.repositories.MotorRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MotorService {

  private final MotorRepository repository;

  public List<Motor> findAll() {
    return repository.findAll();
  }

  public Optional<Motor> findById(Long id) {
    return repository.findById(id);
  }

  public void addMotor(Motor motor) {
    repository.save(motor);
  }

  public void deleteById(Long id) {
    repository.deleteById(id);
  }
}
