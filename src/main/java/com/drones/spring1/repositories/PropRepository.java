package com.drones.spring1.repositories;

import com.drones.spring1.entities.Prop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropRepository extends JpaRepository<Prop, Long> {}
