package com.drones.back.services;

import com.drones.back.dto.BatteryDto;
import com.drones.back.dto.DtoMapper;
import com.drones.back.repositories.BatteryRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BatteryService {

  private final BatteryRepository repository;

  public List<BatteryDto> findAll() {
    return repository.findAll().stream().map(DtoMapper::toDto).toList();
  }

  public Optional<BatteryDto> findById(Long id) {
    return repository.findById(id).map(DtoMapper::toDto);
  }

  public void addBattery(BatteryDto battery) {
    repository.save(DtoMapper.toEntity(battery));
  }

  public void deleteById(Long id) {
    repository.deleteById(id);
  }
}
