package com.drones.back.services;

import com.drones.back.dto.DtoMapper;
import com.drones.back.dto.MotorDto;
import com.drones.back.repositories.MotorRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MotorService {

  private final MotorRepository repository;

  public List<MotorDto> findAll() {
    return repository.findAll().stream().map(DtoMapper::toDto).toList();
  }

  public Optional<MotorDto> findById(Long id) {
    return repository.findById(id).map(DtoMapper::toDto);
  }

  public void addMotor(MotorDto motor) {
    repository.save(DtoMapper.toEntity(motor));
  }

  public void deleteById(Long id) {
    repository.deleteById(id);
  }
}
