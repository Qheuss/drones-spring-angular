package com.drones.back.services;

import com.drones.back.dto.CameraDto;
import com.drones.back.dto.DtoMapper;
import com.drones.back.repositories.CameraRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CameraService {

  private final CameraRepository repository;

  public List<CameraDto> findAll() {
    return repository.findAll().stream().map(DtoMapper::toDto).toList();
  }

  public Optional<CameraDto> findById(Long id) {
    return repository.findById(id).map(DtoMapper::toDto);
  }

  public void addCamera(CameraDto camera) {
    repository.save(DtoMapper.toEntity(camera));
  }

  public void deleteById(Long id) {
    repository.deleteById(id);
  }
}
