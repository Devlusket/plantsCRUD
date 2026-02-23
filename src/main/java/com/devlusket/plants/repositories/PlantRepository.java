package com.devlusket.plants.repositories;

import com.devlusket.plants.models.Plant;

import org.springframework.data.jpa.repository.JpaRepository;


public interface PlantRepository extends JpaRepository<Plant, Integer> {

  Iterable<Plant> findByHasFruit(Boolean hasFruit);
  Iterable<Plant> findByQuantityLessThan(Integer quantity);
  Iterable<Plant> findByHasFruitAndQuantityLessThan(Boolean hasFruit, Integer quantity);

}
