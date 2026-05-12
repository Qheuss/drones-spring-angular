package com.drones.back.dto;

import com.drones.back.enums.VideoLinkType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DroneDto {

  private Long id;

  private String name;

  private PropDto prop;

  private MotorDto motor;

  private FlightControllerDto flightController;

  private CameraDto camera;

  private FrameDto frame;

  private BatteryDto battery;

  private VideoLinkType videoLinkType;

  private Integer propsCount;

  private Integer weightGrams;

  private Integer wheelbaseMm;

  private Integer flightTimeMinutes;
}
