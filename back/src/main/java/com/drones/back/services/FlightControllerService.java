package com.drones.back.services;

import com.drones.back.dto.DtoMapper;
import com.drones.back.dto.FlightControllerDto;
import com.drones.back.repositories.FlightControllerRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FlightControllerService {

  private final FlightControllerRepository repository;

  public List<FlightControllerDto> findAll() {
    return repository.findAll().stream().map(DtoMapper::toDto).toList();
  }

  public Optional<FlightControllerDto> findById(Long id) {
    return repository.findById(id).map(DtoMapper::toDto);
  }

  public void addFlightController(FlightControllerDto flightController) {
    repository.save(DtoMapper.toEntity(flightController));
  }

  public void deleteById(Long id) {
    repository.deleteById(id);
  }
}
