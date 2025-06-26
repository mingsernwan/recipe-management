package com.recipe_management.backend.service;

import java.util.List;
import com.recipe_management.backend.dto.RecipeListDTO;
import com.recipe_management.backend.dto.RecipeRequestDTO;
import com.recipe_management.backend.dto.SaveRecipeDTO;

public interface IRecipeService {
  List<RecipeListDTO> getRecipeList(RecipeRequestDTO recipeRequestDTO);
  void saveRecipe(SaveRecipeDTO saveRecipeDTO);
  void deleteRecipe(Long recipeId);
}
