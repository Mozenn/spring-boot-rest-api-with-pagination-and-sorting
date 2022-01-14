package com.mozen.springbootpaginationandsorting.repository;

import com.mozen.springbootpaginationandsorting.model.Plant;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PlantRepository extends PagingAndSortingRepository<Plant, Long> {
}
