package com.drones.back.dto;

import com.drones.back.entities.Battery;
import com.drones.back.entities.Camera;
import com.drones.back.entities.Drone;
import com.drones.back.entities.FlightController;
import com.drones.back.entities.Frame;
import com.drones.back.entities.Motor;
import com.drones.back.entities.Prop;

public final class DtoMapper {

  private DtoMapper() {}

  public static BatteryDto toDto(Battery battery) {
    if (battery == null) {
      return null;
    }
    BatteryDto dto = new BatteryDto();
    dto.setId(battery.getId());
    dto.setModel(battery.getModel());
    dto.setCapacityMah(battery.getCapacityMah());
    return dto;
  }

  public static Battery toEntity(BatteryDto dto) {
    if (dto == null) {
      return null;
    }
    Battery battery = new Battery();
    battery.setId(dto.getId());
    battery.setModel(dto.getModel());
    battery.setCapacityMah(dto.getCapacityMah());
    return battery;
  }

  public static CameraDto toDto(Camera camera) {
    if (camera == null) {
      return null;
    }
    CameraDto dto = new CameraDto();
    dto.setId(camera.getId());
    dto.setModel(camera.getModel());
    dto.setResolutionMp(camera.getResolutionMp());
    return dto;
  }

  public static Camera toEntity(CameraDto dto) {
    if (dto == null) {
      return null;
    }
    Camera camera = new Camera();
    camera.setId(dto.getId());
    camera.setModel(dto.getModel());
    camera.setResolutionMp(dto.getResolutionMp());
    return camera;
  }

  public static FlightControllerDto toDto(FlightController flightController) {
    if (flightController == null) {
      return null;
    }
    FlightControllerDto dto = new FlightControllerDto();
    dto.setId(flightController.getId());
    dto.setModel(flightController.getModel());
    dto.setChannelCount(flightController.getChannelCount());
    dto.setControlLinkProtocol(flightController.getControlLinkProtocol());
    dto.setControlMode(flightController.getControlMode());
    return dto;
  }

  public static FlightController toEntity(FlightControllerDto dto) {
    if (dto == null) {
      return null;
    }
    FlightController flightController = new FlightController();
    flightController.setId(dto.getId());
    flightController.setModel(dto.getModel());
    flightController.setChannelCount(dto.getChannelCount());
    flightController.setControlLinkProtocol(dto.getControlLinkProtocol());
    flightController.setControlMode(dto.getControlMode());
    return flightController;
  }

  public static FrameDto toDto(Frame frame) {
    if (frame == null) {
      return null;
    }
    FrameDto dto = new FrameDto();
    dto.setId(frame.getId());
    dto.setModel(frame.getModel());
    dto.setMaterial(frame.getMaterial());
    return dto;
  }

  public static Frame toEntity(FrameDto dto) {
    if (dto == null) {
      return null;
    }
    Frame frame = new Frame();
    frame.setId(dto.getId());
    frame.setModel(dto.getModel());
    frame.setMaterial(dto.getMaterial());
    return frame;
  }

  public static MotorDto toDto(Motor motor) {
    if (motor == null) {
      return null;
    }
    MotorDto dto = new MotorDto();
    dto.setId(motor.getId());
    dto.setModel(motor.getModel());
    dto.setKvRating(motor.getKvRating());
    return dto;
  }

  public static Motor toEntity(MotorDto dto) {
    if (dto == null) {
      return null;
    }
    Motor motor = new Motor();
    motor.setId(dto.getId());
    motor.setModel(dto.getModel());
    motor.setKvRating(dto.getKvRating());
    return motor;
  }

  public static PropDto toDto(Prop prop) {
    if (prop == null) {
      return null;
    }
    PropDto dto = new PropDto();
    dto.setId(prop.getId());
    dto.setModel(prop.getModel());
    dto.setSpec(prop.getSpec());
    return dto;
  }

  public static Prop toEntity(PropDto dto) {
    if (dto == null) {
      return null;
    }
    Prop prop = new Prop();
    prop.setId(dto.getId());
    prop.setModel(dto.getModel());
    prop.setSpec(dto.getSpec());
    return prop;
  }

  public static DroneDto toDto(Drone drone) {
    if (drone == null) {
      return null;
    }
    DroneDto dto = new DroneDto();
    dto.setId(drone.getId());
    dto.setName(drone.getName());
    dto.setProp(toDto(drone.getProp()));
    dto.setMotor(toDto(drone.getMotor()));
    dto.setFlightController(toDto(drone.getFlightController()));
    dto.setCamera(toDto(drone.getCamera()));
    dto.setFrame(toDto(drone.getFrame()));
    dto.setBattery(toDto(drone.getBattery()));
    dto.setVideoLinkType(drone.getVideoLinkType());
    dto.setPropsCount(drone.getPropsCount());
    dto.setWeightGrams(drone.getWeightGrams());
    dto.setWheelbaseMm(drone.getWheelbaseMm());
    dto.setFlightTimeMinutes(drone.getFlightTimeMinutes());
    return dto;
  }

  public static Drone toEntity(DroneDto dto) {
    if (dto == null) {
      return null;
    }
    Drone drone = new Drone();
    drone.setId(dto.getId());
    drone.setName(dto.getName());
    drone.setVideoLinkType(dto.getVideoLinkType());
    drone.setPropsCount(dto.getPropsCount());
    drone.setWeightGrams(dto.getWeightGrams());
    drone.setWheelbaseMm(dto.getWheelbaseMm());
    drone.setFlightTimeMinutes(dto.getFlightTimeMinutes());
    return drone;
  }
}
