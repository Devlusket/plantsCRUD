package com.devlusket.plants.controllers;
import com.devlusket.plants.services.PlantService;
import org.springframework.web.bind.annotation.*;

import com.devlusket.plants.dto.PlantRequestDTO;
import com.devlusket.plants.dto.PlantResponseDTO;
import com.devlusket.plants.models.Plant;

import java.util.Optional;

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
  public Optional<Plant> getPlantById(@PathVariable Integer id) {
    return plantService.findById(id);
  }

  @GetMapping("/search")
  public Iterable<Plant> searchPlants(
      @RequestParam(name = "hasFruit", required = false) Boolean hasFruit,
      @RequestParam(name = "maxQuantity", required = false) Integer quantity) {

    return plantService.searchPlants(hasFruit, quantity);
  }

  @PostMapping
  public PlantResponseDTO createNewPlant(@RequestBody PlantRequestDTO dto) {
    return plantService.createNewPlant(dto);
  }

  @PatchMapping("/{id}")
  public Plant updatePlant(@PathVariable Integer id, @RequestBody Plant plant) {
    return plantService.updatePlant(id, plant);
  }

  @DeleteMapping("/{id}")
  public Plant deletePlant(@PathVariable Integer id) {
    plantService.deletePlant(id);
    return null;
  }


}