package com.devlusket.plants.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devlusket.plants.dto.PlantRequestDTO;
import com.devlusket.plants.dto.PlantResponseDTO;
import com.devlusket.plants.mapper.PlantMapper;
import com.devlusket.plants.models.Plant;
import com.devlusket.plants.repositories.PlantRepository;

import jakarta.transaction.Transactional;

@Service
public class PlantService {

  
  private final PlantRepository plantRepository;
  public PlantService(PlantRepository plantRepository) {
    this.plantRepository = plantRepository;
  } 



  public List<PlantResponseDTO> findAllPlants(){
    return this.plantRepository.findAll()
            .stream()
            .map(PlantMapper::toResponseDTO)
            .toList();
  }


  public PlantResponseDTO findById(Integer id) {
    Plant plant = this.plantRepository.findById(id)
                  .orElseThrow(() -> new RuntimeException("Plants not found with id: " + id));
    return PlantMapper.toResponseDTO(plant);
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
  public PlantResponseDTO createNewPlant(PlantRequestDTO dto) {
    Plant plant = PlantMapper.toEntity(dto);
    Plant savedPlant = plantRepository.save(plant);
    return PlantMapper.toResponseDTO(savedPlant);
  }


  @Transactional
  public PlantResponseDTO updatePlant(Integer id, PlantRequestDTO dto) {


    Plant plant = plantRepository.findById(id)
                  .orElseThrow(() -> new RuntimeException("Plant not found with id: " + id));

    PlantMapper.updateEntityFromDTO(plant, dto);

    return PlantMapper.toResponseDTO(plantRepository.save(plant));
  }


  @Transactional
  public void deletePlant(Integer id) {

    plantRepository.findById(id).orElseThrow(() -> new RuntimeException("Plant not found with id: " + id));

    plantRepository.deleteById(id);

  }
}