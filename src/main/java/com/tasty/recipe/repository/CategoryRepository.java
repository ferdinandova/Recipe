package com.tasty.recipe.repository;

import com.tasty.recipe.entity.Category;
import com.tasty.recipe.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findByName(String name);
}
