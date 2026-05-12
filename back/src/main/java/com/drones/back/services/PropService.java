package com.drones.back.services;

import com.drones.back.dto.DtoMapper;
import com.drones.back.dto.PropDto;
import com.drones.back.repositories.PropRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PropService {

  private final PropRepository repository;

  public List<PropDto> findAll() {
    return repository.findAll().stream().map(DtoMapper::toDto).toList();
  }

  public Optional<PropDto> findById(Long id) {
    return repository.findById(id).map(DtoMapper::toDto);
  }

  public void addProp(PropDto prop) {
    repository.save(DtoMapper.toEntity(prop));
  }

  public void deleteById(Long id) {
    repository.deleteById(id);
  }
}
