package com.recipe_management.backend.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.recipe_management.backend.model.Recipe;
import com.recipe_management.backend.repository.RecipeRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class RecipeService implements IRecipeService {
  private final RecipeRepository recipesRepository;

  @Override
  public List<Recipe> getRecipeList() {
    List<Recipe> recipeList = recipesRepository.findAll();
    return recipeList;
  }
  
}
