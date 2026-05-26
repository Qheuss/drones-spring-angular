package com.drones.back.services;

import com.drones.back.dto.FlightControllerDto;
import com.drones.back.repositories.FlightControllerRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FlightControllerService {

  private final FlightControllerRepository repository;
  private final ModelMapper modelMapper;

  public List<FlightControllerDto> findAll() {
    return repository
      .findAll()
      .stream()
      .map(flightController ->
        modelMapper.map(flightController, FlightControllerDto.class)
      )
      .toList();
  }

  public Optional<FlightControllerDto> findById(Long id) {
    return repository
      .findById(id)
      .map(flightController ->
        modelMapper.map(flightController, FlightControllerDto.class)
      );
  }

  public void addFlightController(FlightControllerDto flightController) {
    repository.save(
      modelMapper.map(
        flightController,
        com.drones.back.entities.FlightController.class
      )
    );
  }

  public void deleteById(Long id) {
    repository.deleteById(id);
  }
}
