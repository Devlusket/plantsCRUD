package com.devlusket.plants.mapper;

import com.devlusket.plants.dto.PlantRequestDTO;
import com.devlusket.plants.dto.PlantResponseDTO;
import com.devlusket.plants.models.Plant;

public class PlantMapper {
  private PlantMapper() {
    /* This utility class should not be instantiated */
  }


  public static PlantResponseDTO toResponseDTO(Plant plant) {
    PlantResponseDTO responseDTO = new PlantResponseDTO();
    responseDTO.setId(plant.getId());
    responseDTO.setName(plant.getName());
    responseDTO.setQuantity(plant.getQuantity());
    responseDTO.setWateringFrequency(plant.getWateringFrequency());
    responseDTO.setHasFruit(plant.getHasFruit());
    return responseDTO;
  }

  public static Plant toEntity(PlantRequestDTO requestDTO) {
    Plant plant = new Plant();
    plant.setName(requestDTO.getName());
    plant.setQuantity(requestDTO.getQuantity());
    plant.setWateringFrequency(requestDTO.getWateringFrequency());
    plant.setHasFruit(requestDTO.getHasFruit());
    plant.setAccessPassword(requestDTO.getAccessPassword());
    return plant;
  }

}
