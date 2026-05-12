package com.drones.back.dto;

import com.drones.back.enums.ControlLinkProtocol;
import com.drones.back.enums.FlightControlMode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlightControllerDto {

  private Long id;

  private String model;

  private Integer channelCount;

  private ControlLinkProtocol controlLinkProtocol;

  private FlightControlMode controlMode;
}
