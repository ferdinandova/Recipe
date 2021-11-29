package com.tasty.recipe.repository;

import com.tasty.recipe.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

    List<Recipe> findByName(String name);

}
