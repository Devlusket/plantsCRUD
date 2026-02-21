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

  // public Iterable<Plant> searchPlants(Boolean hasFruit, Integer quantity) {

  //   if (hasFruit != null && quantity != null && hasFruit) {
  //     return this.plantRepository.findByHasFruitTrueAndQuantityLessThanIterable(quantity);
  //   } else if (hasFruit != null && quantity != null && !hasFruit) {
  //     return this.plantRepository.findByHasFruitFalseAndQuantityLessThanIterable(quantity);
  //   } else if (hasFruit != null && hasFruit) {
  //     return this.plantRepository.findByHasFruitTrue();
  //   } else if (hasFruit != null && !hasFruit) {
  //     return this.plantRepository.findByHasFruitFalse();
  //   } else if (quantity != null) {
  //     return this.plantRepository.findByQuantityLessThan(quantity);
  //   } else {
  //     return this.plantRepository.findAll();
  //   }
  // }

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
    Plant newPlant = this.plantRepository.save(plant);
    return newPlant;
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

    if(!plantRepository.existsById(id)) {
      throw new RuntimeException("Plant not found with id: " + id);
    }

    plantRepository.deleteById(id);

  }
}