package com.devlusket.plants.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.devlusket.plants.models.Plant;
import com.devlusket.plants.repositories.PlantRepository;

import jakarta.transaction.Transactional;

@Service
public class PlantService {

  
  private final PlantRepository plantRepository;
  public PlantService(PlantRepository plantRepository) {
    this.plantRepository = plantRepository;
  } 



  public Iterable<Plant> findAllPlants(){
    return this.plantRepository.findAll();
  }


  public Optional<Plant> findById(Integer id) {
    return this.plantRepository.findById(id);
  }


  public Iterable<Plant> searchPlants(Boolean hasFruit, Integer quantity) {


    if (hasFruit != null && quantity != null){
      return this.plantRepository.findByHasFruitAndQuantityLessThan(hasFruit, quantity);
    }

    if (hasFruit != null) {
      return this.plantRepository.findByHasFruit(hasFruit);
    }

    if(quantity != null) {
      return this.plantRepository.findByQuantityLessThan(quantity);
    }

    return this.plantRepository.findAll();
  }



  @Transactional
  public Plant createNewPlant(Plant plant) {
    return this.plantRepository.save(plant);
  }


  @Transactional
  public Plant updatePlant(Integer id, Plant updatedPlant) {


    Plant plant = plantRepository.findById(id).orElseThrow(() -> new RuntimeException("Plant not found with id: " + id));

    if (updatedPlant.getName() != null) {
      plant.setName(updatedPlant.getName());
    }

    if (updatedPlant.getQuantity() != null) {
      plant.setQuantity(updatedPlant.getQuantity());
    }

    if (updatedPlant.getHasFruit() != null) {
      plant.setHasFruit(updatedPlant.getHasFruit());
    }

    if (updatedPlant.getWateringFrequency() != null) {
      plant.setWateringFrequency(updatedPlant.getWateringFrequency());
    }

    return plantRepository.save(plant);
  }


  @Transactional
  public void deletePlant(Integer id) {

    plantRepository.findById(id).orElseThrow(() -> new RuntimeException("Plant not found with id: " + id));

    plantRepository.deleteById(id);

  }
}