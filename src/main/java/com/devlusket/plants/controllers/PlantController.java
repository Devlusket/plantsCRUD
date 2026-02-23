package com.devlusket.plants.controllers;
import com.devlusket.plants.services.PlantService;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.devlusket.plants.dto.PlantRequestDTO;
import com.devlusket.plants.dto.PlantResponseDTO;
import com.devlusket.plants.models.Plant;


@RestController
@RequestMapping("/plants")
public class PlantController {

  private final PlantService plantService;


  public PlantController(PlantService plantService) {
    this.plantService = plantService;
  }

  @GetMapping
  public Iterable<PlantResponseDTO> getAllPlants() {
    return plantService.findAllPlants();
  }

  @GetMapping("/{id}")
  public PlantResponseDTO getPlantById(@PathVariable Integer id) {
    return plantService.findById(id);
  }

  @GetMapping("/search")
  public List<PlantResponseDTO> searchPlants(
      @RequestParam(name = "hasFruit", required = false) Boolean hasFruit,
      @RequestParam(name = "maxQuantity", required = false) Integer quantity) {

    return plantService.searchPlants(hasFruit, quantity);
  }

  @PostMapping
  public PlantResponseDTO createNewPlant(@RequestBody PlantRequestDTO dto) {
    return plantService.createNewPlant(dto);
  }

  @PatchMapping("/{id}")
  public PlantResponseDTO updatePlant(@PathVariable Integer id, @RequestBody PlantRequestDTO dto) {
    return plantService.updatePlant(id, dto);
  }

  @DeleteMapping("/{id}")
  public Plant deletePlant(@PathVariable Integer id) {
    plantService.deletePlant(id);
    return null;
  }


}