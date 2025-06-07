package com.recipe_management.backend.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.recipe_management.backend.dto.RecipeDTO;
import com.recipe_management.backend.dto.SaveRecipeDTO;
import com.recipe_management.backend.model.Recipe;
import com.recipe_management.backend.repository.RecipeRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class RecipeService implements IRecipeService {
  private final RecipeRepository recipeRepository;

  @Override
  public List<RecipeDTO> getRecipeList() {
    List<RecipeDTO> recipeList = recipeRepository.findByActiveFlagTrue();
    return recipeList;
  }

  @Override
  @Transactional
  public void saveRecipe(SaveRecipeDTO saveRecipeDTO) {
    Recipe recipe = new Recipe();
    recipe.setRecipeName(saveRecipeDTO.recipeName());
    recipe.setRecipeDescription(saveRecipeDTO.recipeDescription());
    recipe.setRecipeCookTime(saveRecipeDTO.recipeCookTime());
    recipe.setRecipeDifficulty(saveRecipeDTO.recipeDifficulty());
    recipe.setActiveFlag(true );
    recipeRepository.save(recipe);
  }

  @Override
  @Transactional
  public void deleteRecipe(Long recipeId) {
    Recipe recipe = recipeRepository.findById(recipeId).get();
    recipe.setActiveFlag(false);
    recipeRepository.save(recipe);
  }
}
