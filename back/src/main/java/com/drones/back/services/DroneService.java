package com.drones.back.services;

import com.drones.back.dto.DroneDto;
import com.drones.back.dto.DtoMapper;
import com.drones.back.entities.Drone;
import com.drones.back.repositories.BatteryRepository;
import com.drones.back.repositories.CameraRepository;
import com.drones.back.repositories.DroneRepository;
import com.drones.back.repositories.FlightControllerRepository;
import com.drones.back.repositories.FrameRepository;
import com.drones.back.repositories.MotorRepository;
import com.drones.back.repositories.PropRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DroneService {

  private final DroneRepository repository;
  private final PropRepository propRepository;
  private final MotorRepository motorRepository;
  private final FlightControllerRepository flightControllerRepository;
  private final CameraRepository cameraRepository;
  private final FrameRepository frameRepository;
  private final BatteryRepository batteryRepository;

  public List<DroneDto> findAll() {
    return repository.findAll().stream().map(DtoMapper::toDto).toList();
  }

  public Optional<DroneDto> findById(Long id) {
    return repository.findById(id).map(DtoMapper::toDto);
  }

  public void addDrone(DroneDto drone) {
    Drone entity = DtoMapper.toEntity(drone);
    entity.setProp(resolveProp(drone));
    entity.setMotor(resolveMotor(drone));
    entity.setFlightController(resolveFlightController(drone));
    entity.setCamera(resolveCamera(drone));
    entity.setFrame(resolveFrame(drone));
    entity.setBattery(resolveBattery(drone));
    repository.save(entity);
  }

  public void deleteById(Long id) {
    repository.deleteById(id);
  }

  private com.drones.back.entities.Prop resolveProp(DroneDto drone) {
    if (drone.getProp() == null || drone.getProp().getId() == null) {
      return null;
    }
    return propRepository.getReferenceById(drone.getProp().getId());
  }

  private com.drones.back.entities.Motor resolveMotor(DroneDto drone) {
    if (drone.getMotor() == null || drone.getMotor().getId() == null) {
      return null;
    }
    return motorRepository.getReferenceById(drone.getMotor().getId());
  }

  private com.drones.back.entities.FlightController resolveFlightController(
    DroneDto drone
  ) {
    if (
      drone.getFlightController() == null ||
      drone.getFlightController().getId() == null
    ) {
      return null;
    }
    return flightControllerRepository.getReferenceById(
      drone.getFlightController().getId()
    );
  }

  private com.drones.back.entities.Camera resolveCamera(DroneDto drone) {
    if (drone.getCamera() == null || drone.getCamera().getId() == null) {
      return null;
    }
    return cameraRepository.getReferenceById(drone.getCamera().getId());
  }

  private com.drones.back.entities.Frame resolveFrame(DroneDto drone) {
    if (drone.getFrame() == null || drone.getFrame().getId() == null) {
      return null;
    }
    return frameRepository.getReferenceById(drone.getFrame().getId());
  }

  private com.drones.back.entities.Battery resolveBattery(DroneDto drone) {
    if (drone.getBattery() == null || drone.getBattery().getId() == null) {
      return null;
    }
    return batteryRepository.getReferenceById(drone.getBattery().getId());
  }
}
