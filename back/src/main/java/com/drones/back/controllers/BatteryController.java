package com.drones.back.controllers;

import com.drones.back.entities.Battery;
import com.drones.back.services.BatteryService;
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
@RequestMapping("/batteries")
public class BatteryController {

  private final BatteryService service;

  @GetMapping("/all")
  public List<Battery> findAll() {
    return service.findAll();
  }

  @GetMapping("/{id}")
  public Optional<Battery> findById(@PathVariable("id") Long id) {
    return service.findById(id);
  }

  @PostMapping("/new")
  public void addBattery(@RequestBody Battery battery) {
    service.addBattery(battery);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable("id") Long id) {
    service.deleteById(id);
  }
}
