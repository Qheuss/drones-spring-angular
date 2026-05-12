package com.drones.back.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BatteryDto {

  private Long id;

  private String model;

  private Integer capacityMah;
}
