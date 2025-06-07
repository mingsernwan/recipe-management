package com.recipe_management.backend.service;

import java.util.List;

import com.recipe_management.backend.dto.RecipeDTO;
import com.recipe_management.backend.dto.SaveRecipeDTO;

public interface IRecipeService {
  List<RecipeDTO> getRecipeList();
  void saveRecipe(SaveRecipeDTO saveRecipeDTO);
  void deleteRecipe(Long recipeId);
}
