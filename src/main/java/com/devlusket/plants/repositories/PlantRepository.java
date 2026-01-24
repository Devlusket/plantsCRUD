package com.devlusket.plants.repositories;

import com.devlusket.plants.models.Plant;
import org.springframework.data.repository.CrudRepository;


public interface PlantRepository extends CrudRepository<Plant, Integer> {

  Iterable<Plant> findByHasFruitTrue();
  Iterable<Plant> findByHasFruitFalse();
  Iterable<Plant> findByQuantityLessThan(Integer quantity);
  Iterable<Plant> findByHasFruitTrueAndQuantityLessThanIterable(Integer quantity);
  Iterable<Plant> findByHasFruitFalseAndQuantityLessThanIterable(Integer quantity);

}
