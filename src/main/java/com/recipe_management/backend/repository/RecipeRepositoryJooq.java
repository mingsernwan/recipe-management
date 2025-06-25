package com.recipe_management.backend.repository;

import static org.jooq.impl.DSL.*;
import java.util.List;
import org.jooq.Condition;
import com.recipe_management.backend.dto.RecipeListDTO;
import com.recipe_management.backend.dto.RecipeRequestDTO;
import com.util.JooqUtil;

import lombok.AllArgsConstructor;

import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record4;
import org.jooq.SelectConditionStep;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor

public class RecipeRepositoryJooq {
  DSLContext dsl;

  public List<RecipeListDTO> getRecipeList(RecipeRequestDTO recipeRequestDTO){
    Condition condition = noCondition();
    Field<String> recipeName = field("REC.recipe_name", String.class).as("recipeName");
    Field<String> recipeDescription = field("REC.recipe_description", String.class).as("recipeDescription");
    Field<String> recipeCookTime = field("REC.recipe_cook_time", String.class).as("recipeCookTime");
    Field<String> recipeDifficulty = field("REC.recipe_difficulty", String.class).as("recipeDifficulty");
    condition =
        JooqUtil.andCondition(condition,  field("REC.recipe_name"), Field::containsIgnoreCase, recipeRequestDTO.recipeName());
    condition =
        JooqUtil.andCondition(condition,  field("REC.recipe_description"), Field::containsIgnoreCase, recipeRequestDTO.recipeDescription());
    condition =
        JooqUtil.andCondition(condition,  field("REC.recipe_difficulty"), Field::containsIgnoreCase, recipeRequestDTO.recipeDifficulty());
    SelectConditionStep <Record4<String, String, String, String>> query =
    dsl.select( recipeName, recipeDescription, recipeCookTime, recipeDifficulty)
    .from(table("rm_recipes REC"))
    .where(condition);

    return query.fetchInto(RecipeListDTO.class);
  };  
}
