package com.drones.back.controllers;

import com.drones.back.entities.Drone;
import com.drones.back.services.DroneService;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
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
  public List<Drone> findAll() {
    return service.findAll();
  }

  @GetMapping("/{id}")
  public Optional<Drone> findById(@PathVariable("id") Long id) {
    return service.findById(id);
  }

  @PostMapping("/new")
  public void addDrone(@RequestBody Drone drone) {
    service.addDrone(drone);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable("id") Long id) {
    service.deleteById(id);
  }
}
