package com.recipe_management.backend.dto;

public record SaveRecipeDTO(
   String recipeName,
   String recipeDescription,
   String recipeCookTime,
   String recipeDifficulty
) {}
