package com.drones.spring1.controllers;

import com.drones.spring1.entities.Camera;
import com.drones.spring1.services.CameraService;
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
  origins = { "http://localhost:4200/" },
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
@RequestMapping("/cameras")
public class CameraController {

  private final CameraService service;

  @GetMapping("/all")
  public List<Camera> findAll() {
    return service.findAll();
  }

  @GetMapping("/{id}")
  public Optional<Camera> findById(@PathVariable("id") Long id) {
    return service.findById(id);
  }

  @PostMapping("/new")
  public void addCamera(@RequestBody Camera camera) {
    service.addCamera(camera);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable("id") Long id) {
    service.deleteById(id);
  }
}
