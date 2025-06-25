package com.recipe_management.backend.dto;

public record RecipeListDTO (
  String recipeName,
  String recipeDescription,
  String recipeCookTime,
  String recipeDifficulty
) {}
