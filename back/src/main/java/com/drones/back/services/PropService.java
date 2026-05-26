package com.drones.back.services;

import com.drones.back.dto.PropDto;
import com.drones.back.repositories.PropRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PropService {

  private final PropRepository repository;
  private final ModelMapper modelMapper;

  public List<PropDto> findAll() {
    return repository
      .findAll()
      .stream()
      .map(prop -> modelMapper.map(prop, PropDto.class))
      .toList();
  }

  public Optional<PropDto> findById(Long id) {
    return repository
      .findById(id)
      .map(prop -> modelMapper.map(prop, PropDto.class));
  }

  public void addProp(PropDto prop) {
    repository.save(modelMapper.map(prop, com.drones.back.entities.Prop.class));
  }

  public void deleteById(Long id) {
    repository.deleteById(id);
  }
}
