package com.recipe_management.backend.dto;

public record RecipeRequestDTO (
  String recipeName,
  String recipeDescription,
  String recipeDifficulty
) {}
