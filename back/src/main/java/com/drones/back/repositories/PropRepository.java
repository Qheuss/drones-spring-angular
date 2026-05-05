package com.drones.back.repositories;

import com.drones.back.entities.Prop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropRepository extends JpaRepository<Prop, Long> {}
