package com.drones.back.controllers;

import com.drones.back.entities.Frame;
import com.drones.back.services.FrameService;
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
@RequestMapping("/frames")
public class FrameController {

  private final FrameService service;

  @GetMapping("/all")
  public List<Frame> findAll() {
    return service.findAll();
  }

  @GetMapping("/{id}")
  public Optional<Frame> findById(@PathVariable("id") Long id) {
    return service.findById(id);
  }

  @PostMapping("/new")
  public void addFrame(@RequestBody Frame frame) {
    service.addFrame(frame);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable("id") Long id) {
    service.deleteById(id);
  }
}
