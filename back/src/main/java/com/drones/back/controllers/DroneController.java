package com.drones.back.controllers;

import com.drones.back.dto.DroneDto;
import com.drones.back.services.DroneService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin(
  origins = { "http://localhost:4200" },
  methods = {
    RequestMethod.GET,
    RequestMethod.POST,
    RequestMethod.PUT,
    RequestMethod.DELETE,
    RequestMethod.OPTIONS,
  },
  maxAge = 3600L
)
@Transactional
@RequestMapping("/drones")
public class DroneController {

  private final DroneService service;

  @GetMapping("/all")
  public List<DroneDto> findAll() {
    return service.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<DroneDto> findById(@PathVariable("id") Long id) {
    return service
      .findById(id)
      .map(ResponseEntity::ok)
      .orElseThrow(() ->
        new com.drones.back.exceptions.NotFoundException(
          "Drone not found with ID: " + id
        )
      );
  }

  @PostMapping("/new")
  public ResponseEntity<DroneDto> addDrone(@RequestBody DroneDto drone) {
    log.info("Creating drone: {}", drone.getName());
    DroneDto createdDrone = service.addDrone(drone);
    log.info("Drone created successfully with ID: {}", createdDrone.getId());
    return ResponseEntity.status(HttpStatus.CREATED).body(createdDrone);
  }

  @PutMapping("/{id}")
  public ResponseEntity<DroneDto> updateDrone(
    @PathVariable("id") Long id,
    @RequestBody DroneDto drone
  ) {
    log.info("Updating drone id {}: {}", id, drone.getName());
    DroneDto updated = service.updateDrone(id, drone);
    return ResponseEntity.ok(updated);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
    service.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
