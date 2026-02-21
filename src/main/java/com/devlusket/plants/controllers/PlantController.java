package com.devlusket.plants.controllers;
import com.devlusket.plants.services.PlantService;
import org.springframework.web.bind.annotation.*;

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
  public Iterable<Plant> getAllPlants() {
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
  public Plant createNewPlant(@RequestBody Plant plant) {
    return plantService.createNewPlant(plant);
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