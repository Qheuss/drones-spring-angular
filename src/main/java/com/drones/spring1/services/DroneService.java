package com.drones.spring1.services;

import com.drones.spring1.entities.Drone;
import com.drones.spring1.repositories.DroneRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DroneService {

  private final DroneRepository repository;

  public List<Drone> findAll() {
    //public valeur retournée nom de la méthode (param si besoin)
    return repository.findAll();
  }

  public Optional<Drone> findById(Long id) {
    return repository.findById(id);
  }

  public void addDrone(Drone Drone) {
    //void permet de faire une méthode qui ne retourne rien
    repository.save(Drone);
  }

  public void deleteById(Long id) {
    repository.deleteById(id);
  }
}
