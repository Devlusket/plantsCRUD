package com.devlusket.plants.controllers;

import org.springframework.web.bind.annotation.*;

import com.devlusket.plants.models.Plant;
import com.devlusket.plants.repositories.PlantRepository;

import java.util.*;


@RestController
@RequestMapping("/plants")
public class PlantController {

  private final PlantRepository plantRepository;

  public PlantController(PlantRepository plantRepository) {
    this.plantRepository = plantRepository;
  }

  @GetMapping
  public Iterable<Plant> getAllPlants() {
    return this.plantRepository.findAll();
  }

  @GetMapping("/{id}")
  public Optional<Plant> getPlantById(@PathVariable Integer id) {
    return this.plantRepository.findById(id);
  }

  @PostMapping
  public Plant createNewPlant(@RequestBody Plant plant) {
    Plant newPlant = this.plantRepository.save(plant);
    return newPlant;
  }

  @PutMapping("/{id}")
  public Plant updatePlant(@PathVariable Integer id, @RequestBody Plant plant) {
    Optional<Plant> plantToUpdateOptional = this.plantRepository.findById(id);
    if (!plantToUpdateOptional.isPresent()){
      return null;
    }

    Plant plantToUpdate = plantToUpdateOptional.get();

    if (plant.getName() != null) {
      plantToUpdate.setName(plant.getName());
    }

    if (plant.getQuantity() != null) {
      plantToUpdate.setQuantity(plant.getQuantity());
    }

    if (plant.getWateringFrequency() != null) {
      plantToUpdate.setWateringFrequency(plant.getWateringFrequency());
    }

    if (plant.getHasFruit() != null) {
      plantToUpdate.setHasFruit(plant.getHasFruit());
    }

    Plant updatedPlant = this.plantRepository.save(plantToUpdate);
    return updatedPlant;
  }

  @DeleteMapping("/{id}")
  public Plant deletePlant(@PathVariable("id") Integer id) {
    Optional<Plant> plantToDeleteOptional = this.plantRepository.findById(id);

    if (!plantToDeleteOptional.isPresent()) {
      return null;
    }

    Plant plantToDelete = plantToDeleteOptional.get();
    this.plantRepository.delete(plantToDelete);
    return plantToDelete;
  }




  




}