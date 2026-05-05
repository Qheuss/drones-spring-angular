package com.drones.back.entities;

import com.drones.back.enums.VideoLinkType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "drones")
@Getter
@Setter
public class Drone {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @ManyToOne
  @JoinColumn(name = "prop_id")
  private Prop prop;

  @ManyToOne
  @JoinColumn(name = "motor_id")
  private Motor motor;

  @ManyToOne
  @JoinColumn(name = "flight_controller_id")
  private FlightController flightController;

  @ManyToOne
  @JoinColumn(name = "camera_id")
  private Camera camera;

  @ManyToOne
  @JoinColumn(name = "frame_id")
  private Frame frame;

  @ManyToOne
  @JoinColumn(name = "battery_id")
  private Battery battery;

  @Enumerated(EnumType.STRING)
  @Column(name = "video_link_type", nullable = false)
  private VideoLinkType videoLinkType;

  @Column(name = "props_count", nullable = false)
  private Integer propsCount;

  private Integer weightGrams;

  private Integer wheelbaseMm;

  private Integer flightTimeMinutes;
}
