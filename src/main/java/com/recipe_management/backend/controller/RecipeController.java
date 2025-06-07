package com.recipe_management.backend.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.recipe_management.backend.dto.SaveRecipeDTO;
import com.recipe_management.backend.model.Recipe;
import com.recipe_management.backend.service.IRecipeService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/recipes")
public class RecipeController {
  private final IRecipeService recipesService;

  @GetMapping("")
  public List<Recipe> getRecipeList() {
    return recipesService.getRecipeList();
  }

  @PostMapping("/save")
  public void saveRecipe(
    @RequestBody SaveRecipeDTO saveRecipeDTO
  ){
    recipesService.saveRecipe(saveRecipeDTO);
  }
}
