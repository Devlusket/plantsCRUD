package com.devlusket.plants.repositories;

import com.devlusket.plants.models.Plant;
import org.springframework.data.repository.CrudRepository;


public interface PlantRepository extends CrudRepository<Plant, Integer> {

  Iterable<Plant> findByHasFruit(Boolean hasFruit);
  Iterable<Plant> findByQuantityLessThan(Integer quantity);
  Iterable<Plant> findByHasFruitAndQuantityLessThan(Boolean hasFruit, Integer quantity);

}
