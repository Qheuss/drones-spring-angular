package com.drones.back.mappers;

import com.drones.back.dto.DroneDto;
import com.drones.back.entities.Drone;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DroneMapper {

  private final ModelMapper modelMapper;

  public DroneMapper(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }

  public DroneDto toDto(Drone drone) {
    if (drone == null) {
      return null;
    }
    return modelMapper.map(drone, DroneDto.class);
  }

  public Drone toEntity(DroneDto dto) {
    if (dto == null) {
      return null;
    }
    Drone drone = modelMapper.map(dto, Drone.class);
    if (drone.getIsDeleted() == null) {
      drone.setIsDeleted(Boolean.FALSE);
    }
    return drone;
  }
}
