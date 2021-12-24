package com.mozen.springbootpaginationandsorting.repository;

import com.mozen.springbootpaginationandsorting.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepository extends JpaRepository<Plant, Long> {
}
