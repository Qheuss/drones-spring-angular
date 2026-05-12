package com.drones.back.services;

import com.drones.back.dto.DtoMapper;
import com.drones.back.dto.FrameDto;
import com.drones.back.repositories.FrameRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FrameService {

  private final FrameRepository repository;

  public List<FrameDto> findAll() {
    return repository.findAll().stream().map(DtoMapper::toDto).toList();
  }

  public Optional<FrameDto> findById(Long id) {
    return repository.findById(id).map(DtoMapper::toDto);
  }

  public void addFrame(FrameDto frame) {
    repository.save(DtoMapper.toEntity(frame));
  }

  public void deleteById(Long id) {
    repository.deleteById(id);
  }
}
