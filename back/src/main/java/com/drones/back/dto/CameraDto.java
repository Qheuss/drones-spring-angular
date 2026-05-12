package com.drones.back.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CameraDto {

  private Long id;

  private String model;

  private Integer resolutionMp;
}
