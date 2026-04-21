package com.drones.spring1.services;

import com.drones.spring1.entities.Camera;
import com.drones.spring1.repositories.CameraRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CameraService {

  private final CameraRepository repository;

  public List<Camera> findAll() {
    return repository.findAll();
  }

  public Optional<Camera> findById(Long id) {
    return repository.findById(id);
  }

  public void addCamera(Camera camera) {
    repository.save(camera);
  }

  public void deleteById(Long id) {
    repository.deleteById(id);
  }
}
