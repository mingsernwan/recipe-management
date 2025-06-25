package com.recipe_management.backend.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.recipe_management.backend.dto.RecipeListDTO;
import com.recipe_management.backend.dto.RecipeRequestDTO;
import com.recipe_management.backend.dto.SaveRecipeDTO;
import com.recipe_management.backend.service.IRecipeService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/recipes")
public class RecipeController {
  private final IRecipeService recipesService;

  @GetMapping("")
  public List<RecipeListDTO> getRecipeList(
    @RequestParam(required = false) String recipeName,
    @RequestParam(required = false) String recipeDescription,
    @RequestParam(required = false) String recipeDifficulty) {
      RecipeRequestDTO requestDTO =
        new RecipeRequestDTO(
            recipeName,
            recipeDescription,
            recipeDifficulty);
    return recipesService.getRecipeList(requestDTO);
  }

  @PostMapping("/save")
  public void saveRecipe(
    @RequestBody SaveRecipeDTO saveRecipeDTO
  ){
    recipesService.saveRecipe(saveRecipeDTO);
  }

  @PostMapping("/{recipeId}/delete")
  public void deleteRecipe(
    @PathVariable Long recipeId
  ){
    recipesService.deleteRecipe(recipeId);
  }
}
