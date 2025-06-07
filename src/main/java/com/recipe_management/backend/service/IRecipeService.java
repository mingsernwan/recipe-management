package com.recipe_management.backend.service;

import java.util.List;
import com.recipe_management.backend.model.Recipe;

public interface IRecipeService {
  List<Recipe> getRecipeList();
}
