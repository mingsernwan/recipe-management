package com.recipe_management.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.recipe_management.backend.dto.RecipeDTO;
import com.recipe_management.backend.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
  List<RecipeDTO> findByActiveFlagTrue();
}
