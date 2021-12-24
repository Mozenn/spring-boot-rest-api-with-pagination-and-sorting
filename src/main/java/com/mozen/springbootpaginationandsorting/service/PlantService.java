package com.mozen.springbootpaginationandsorting.service;

import com.mozen.springbootpaginationandsorting.mapper.PageToPageDTOMapper;
import com.mozen.springbootpaginationandsorting.model.PageDTO;
import com.mozen.springbootpaginationandsorting.model.PageSettings;
import com.mozen.springbootpaginationandsorting.model.Plant;
import com.mozen.springbootpaginationandsorting.repository.PlantRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class PlantService {

    private PlantRepository plantRepository;

    private PageToPageDTOMapper<Plant> pageToPageDTOMapper;

    @Autowired
    public PlantService(
            PlantRepository plantRepository,
            PageToPageDTOMapper<Plant> pageToPageDTOMapper) {
        this.plantRepository = plantRepository;
        this.pageToPageDTOMapper = pageToPageDTOMapper;
    }

    public PageDTO<Plant> getPlantPage(@NonNull PageSettings pageSetting) {

        Sort plantSort = pageSetting.buildSort();
        Pageable plantPage = PageRequest.of(pageSetting.getPage(), pageSetting.getElementPerPage(), plantSort);

        return pageToPageDTOMapper.pageToPageDTO(plantRepository.findAll(plantPage));
    }
}
