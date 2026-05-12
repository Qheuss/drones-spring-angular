package com.drones.back.entities;

import com.drones.back.enums.ControlLinkProtocol;
import com.drones.back.enums.FlightControlMode;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "flight_controllers")
@Getter
@Setter
public class FlightController {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String model;

  private Integer channelCount;

  @Enumerated(EnumType.STRING)
  @Column(name = "control_link_protocol", nullable = false)
  private ControlLinkProtocol controlLinkProtocol;

  @Enumerated(EnumType.STRING)
  @Column(name = "control_mode", nullable = false)
  private FlightControlMode controlMode;
}
