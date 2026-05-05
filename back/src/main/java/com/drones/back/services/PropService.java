package com.drones.back.services;

import com.drones.back.entities.Prop;
import com.drones.back.repositories.PropRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PropService {

  private final PropRepository repository;

  public List<Prop> findAll() {
    return repository.findAll();
  }

  public Optional<Prop> findById(Long id) {
    return repository.findById(id);
  }

  public void addProp(Prop prop) {
    repository.save(prop);
  }

  public void deleteById(Long id) {
    repository.deleteById(id);
  }
}
