package com.recipe_management.backend.dto;

public record RecipeDTO (
  String recipeName,
  String recipeDescription,
  String recipeCookTime,
  String recipeDifficulty
) {}
