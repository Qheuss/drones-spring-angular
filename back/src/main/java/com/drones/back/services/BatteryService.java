package com.drones.back.services;

import com.drones.back.dto.BatteryDto;
import com.drones.back.repositories.BatteryRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BatteryService {

  private final BatteryRepository repository;
  private final ModelMapper modelMapper;

  public List<BatteryDto> findAll() {
    return repository
      .findAll()
      .stream()
      .map(battery -> modelMapper.map(battery, BatteryDto.class))
      .toList();
  }

  public Optional<BatteryDto> findById(Long id) {
    return repository
      .findById(id)
      .map(battery -> modelMapper.map(battery, BatteryDto.class));
  }

  public void addBattery(BatteryDto battery) {
    repository.save(
      modelMapper.map(battery, com.drones.back.entities.Battery.class)
    );
  }

  public void deleteById(Long id) {
    repository.deleteById(id);
  }
}
