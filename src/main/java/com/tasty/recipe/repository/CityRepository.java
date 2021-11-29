package com.tasty.recipe.repository;

import com.tasty.recipe.entity.City;
import com.tasty.recipe.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
    List<City> findByName(String name);
}
