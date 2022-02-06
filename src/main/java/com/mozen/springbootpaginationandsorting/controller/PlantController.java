package com.mozen.springbootpaginationandsorting.controller;

import com.mozen.springbootpaginationandsorting.mapper.PageToPageDTOMapper;
import com.mozen.springbootpaginationandsorting.model.PageDTO;
import com.mozen.springbootpaginationandsorting.model.PageSettings;
import com.mozen.springbootpaginationandsorting.model.Plant;
import com.mozen.springbootpaginationandsorting.service.PlantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController()
@RequestMapping("/plant")
public class PlantController {

    private PlantService plantService;

    private PageToPageDTOMapper<Plant> pageToPageDTOMapper;

    public PlantController(PlantService plantService, PageToPageDTOMapper<Plant> pageToPageDTOMapper) {
        this.plantService = plantService;
        this.pageToPageDTOMapper = pageToPageDTOMapper;
    }

    @GetMapping("/page")
    public PageDTO<Plant> getPlantPage(PageSettings pageSettings) {

        log.info(
                "Request for plant page received with data : " + pageSettings);

        return pageToPageDTOMapper.pageToPageDTO(plantService.getPlantPage(pageSettings));
    }
}
