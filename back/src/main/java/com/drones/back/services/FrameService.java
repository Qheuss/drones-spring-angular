package com.drones.back.services;

import com.drones.back.entities.Frame;
import com.drones.back.repositories.FrameRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FrameService {

  private final FrameRepository repository;

  public List<Frame> findAll() {
    return repository.findAll();
  }

  public Optional<Frame> findById(Long id) {
    return repository.findById(id);
  }

  public void addFrame(Frame frame) {
    repository.save(frame);
  }

  public void deleteById(Long id) {
    repository.deleteById(id);
  }
}
