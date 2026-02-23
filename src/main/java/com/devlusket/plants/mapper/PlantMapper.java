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

  public static void updateEntityFromDTO(Plant plant, PlantRequestDTO dto) {
    if (dto.getName() != null) {
      plant.setName(dto.getName());
    }

    if (dto.getQuantity() != null) {
      plant.setQuantity(dto.getQuantity());
    }

    if (dto.getHasFruit() != null) {
      plant.setHasFruit(dto.getHasFruit());
    }

    if (dto.getWateringFrequency() != null) {
      plant.setWateringFrequency(dto.getWateringFrequency());
    }
  }
}
