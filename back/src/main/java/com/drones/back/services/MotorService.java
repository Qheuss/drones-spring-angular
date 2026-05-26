package com.drones.back.services;

import com.drones.back.dto.MotorDto;
import com.drones.back.repositories.MotorRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MotorService {

  private final MotorRepository repository;
  private final ModelMapper modelMapper;

  public List<MotorDto> findAll() {
    return repository
      .findAll()
      .stream()
      .map(motor -> modelMapper.map(motor, MotorDto.class))
      .toList();
  }

  public Optional<MotorDto> findById(Long id) {
    return repository
      .findById(id)
      .map(motor -> modelMapper.map(motor, MotorDto.class));
  }

  public void addMotor(MotorDto motor) {
    repository.save(
      modelMapper.map(motor, com.drones.back.entities.Motor.class)
    );
  }

  public void deleteById(Long id) {
    repository.deleteById(id);
  }
}
