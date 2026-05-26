package com.drones.back.services;

import com.drones.back.dto.FrameDto;
import com.drones.back.repositories.FrameRepository;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FrameService {

  private final FrameRepository repository;
  private final ModelMapper modelMapper;

  public List<FrameDto> findAll() {
    return repository
      .findAll()
      .stream()
      .map(frame -> modelMapper.map(frame, FrameDto.class))
      .toList();
  }

  public Optional<FrameDto> findById(Long id) {
    return repository
      .findById(id)
      .map(frame -> modelMapper.map(frame, FrameDto.class));
  }

  public void addFrame(FrameDto frame) {
    repository.save(
      modelMapper.map(frame, com.drones.back.entities.Frame.class)
    );
  }

  public void deleteById(Long id) {
    repository.deleteById(id);
  }
}
