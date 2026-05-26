package com.drones.back.services;

import com.drones.back.dto.DroneDto;
import com.drones.back.entities.Drone;
import com.drones.back.exceptions.NotFoundException;
import com.drones.back.exceptions.ValidationException;
import com.drones.back.mappers.DroneMapper;
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
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Slf4j
public class DroneService {

  private final DroneRepository repository;
  private final DroneMapper droneMapper;
  private final PropRepository propRepository;
  private final MotorRepository motorRepository;
  private final FlightControllerRepository flightControllerRepository;
  private final CameraRepository cameraRepository;
  private final FrameRepository frameRepository;
  private final BatteryRepository batteryRepository;

  public List<DroneDto> findAll() {
    return repository.findAll().stream().map(droneMapper::toDto).toList();
  }

  public Optional<DroneDto> findById(Long id) {
    return repository.findById(id).map(droneMapper::toDto);
  }

  @Transactional
  public DroneDto addDrone(DroneDto drone) {
    validateDrone(drone);
    Drone entity = droneMapper.toEntity(drone);
    applyRelations(entity, drone);
    Drone savedDrone = repository.save(entity);
    log.debug("Drone saved with ID: {}", savedDrone.getId());
    return droneMapper.toDto(savedDrone);
  }

  public void deleteById(Long id) {
    repository
      .findById(id)
      .ifPresent(drone -> {
        drone.setIsDeleted(true);
        repository.save(drone);
      });
  }

  @Transactional
  public DroneDto updateDrone(Long id, DroneDto drone) {
    validateDrone(drone);
    return repository
      .findById(id)
      .map(existing -> {
        copyMutableFields(existing, drone);
        applyRelations(existing, drone);
        Drone updated = repository.save(existing);
        log.debug("Drone updated with ID: {}", updated.getId());
        return droneMapper.toDto(updated);
      })
      .orElseThrow(() ->
        new NotFoundException("Drone not found with ID: " + id)
      );
  }

  private void applyRelations(Drone entity, DroneDto drone) {
    entity.setProp(resolveProp(drone));
    entity.setMotor(resolveMotor(drone));
    entity.setFlightController(resolveFlightController(drone));
    entity.setCamera(resolveCamera(drone));
    entity.setFrame(resolveFrame(drone));
    entity.setBattery(resolveBattery(drone));
  }

  private void copyMutableFields(Drone entity, DroneDto drone) {
    entity.setName(drone.getName());
    entity.setVideoLinkType(drone.getVideoLinkType());
    entity.setPropsCount(drone.getPropsCount());
    entity.setWeightGrams(drone.getWeightGrams());
    entity.setWheelbaseMm(drone.getWheelbaseMm());
    entity.setFlightTimeMinutes(drone.getFlightTimeMinutes());
    entity.setIsDeleted(
      drone.getIsDeleted() == null
        ? entity.getIsDeleted()
        : drone.getIsDeleted()
    );
  }

  private com.drones.back.entities.Prop resolveProp(DroneDto drone) {
    if (drone.getProp() == null || drone.getProp().getId() == null) {
      return null;
    }
    return propRepository
      .findById(drone.getProp().getId())
      .orElseThrow(() ->
        new NotFoundException(
          "Prop not found with ID: " + drone.getProp().getId()
        )
      );
  }

  private com.drones.back.entities.Motor resolveMotor(DroneDto drone) {
    if (drone.getMotor() == null || drone.getMotor().getId() == null) {
      return null;
    }
    return motorRepository
      .findById(drone.getMotor().getId())
      .orElseThrow(() ->
        new NotFoundException(
          "Motor not found with ID: " + drone.getMotor().getId()
        )
      );
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
    return flightControllerRepository
      .findById(drone.getFlightController().getId())
      .orElseThrow(() ->
        new NotFoundException(
          "FlightController not found with ID: " +
            drone.getFlightController().getId()
        )
      );
  }

  private com.drones.back.entities.Camera resolveCamera(DroneDto drone) {
    if (drone.getCamera() == null || drone.getCamera().getId() == null) {
      return null;
    }
    return cameraRepository
      .findById(drone.getCamera().getId())
      .orElseThrow(() ->
        new NotFoundException(
          "Camera not found with ID: " + drone.getCamera().getId()
        )
      );
  }

  private com.drones.back.entities.Frame resolveFrame(DroneDto drone) {
    if (drone.getFrame() == null || drone.getFrame().getId() == null) {
      return null;
    }
    return frameRepository
      .findById(drone.getFrame().getId())
      .orElseThrow(() ->
        new NotFoundException(
          "Frame not found with ID: " + drone.getFrame().getId()
        )
      );
  }

  private com.drones.back.entities.Battery resolveBattery(DroneDto drone) {
    if (drone.getBattery() == null || drone.getBattery().getId() == null) {
      return null;
    }
    return batteryRepository
      .findById(drone.getBattery().getId())
      .orElseThrow(() ->
        new NotFoundException(
          "Battery not found with ID: " + drone.getBattery().getId()
        )
      );
  }

  private void validateDrone(DroneDto drone) {
    if (drone.getVideoLinkType() == null) {
      log.warn(
        "Drone validation failed: videoLinkType is required but was null"
      );
      throw new ValidationException("videoLinkType is required");
    }
    if (drone.getPropsCount() == null || drone.getPropsCount() <= 0) {
      log.warn("Drone validation failed: propsCount must be greater than 0");
      throw new ValidationException("propsCount must be greater than 0");
    }
    if (drone.getName() == null || drone.getName().isBlank()) {
      log.warn("Drone validation failed: name is required");
      throw new ValidationException("name is required");
    }
  }
}
