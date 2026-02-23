package com.devlusket.plants.repositories;

import com.devlusket.plants.models.Plant;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface PlantRepository extends JpaRepository<Plant, Integer> {

  List<Plant> findByHasFruit(Boolean hasFruit);
  List<Plant> findByQuantityLessThan(Integer quantity);
  List<Plant> findByHasFruitAndQuantityLessThan(Boolean hasFruit, Integer quantity);

}
