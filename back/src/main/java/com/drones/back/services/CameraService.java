package com.drones.back.services;

import com.drones.back.dto.CameraDto;
import com.drones.back.repositories.CameraRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CameraService {

  private final CameraRepository repository;
  private final ModelMapper modelMapper;

  public List<CameraDto> findAll() {
    return repository
      .findAll()
      .stream()
      .map(camera -> modelMapper.map(camera, CameraDto.class))
      .toList();
  }

  public Optional<CameraDto> findById(Long id) {
    return repository
      .findById(id)
      .map(camera -> modelMapper.map(camera, CameraDto.class));
  }

  public void addCamera(CameraDto camera) {
    repository.save(
      modelMapper.map(camera, com.drones.back.entities.Camera.class)
    );
  }

  public void deleteById(Long id) {
    repository.deleteById(id);
  }
}
