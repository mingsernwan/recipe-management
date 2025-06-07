package com.recipe_management.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.recipe_management.backend.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
  
}
