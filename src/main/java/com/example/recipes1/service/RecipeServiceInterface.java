package com.example.recipes1.service;

import com.example.recipes1.model.Recipe;

import java.util.List;

public interface RecipeServiceInterface {

   Recipe add(Recipe recipe);

    Recipe get(String id);

    Recipe update (String id, Recipe recipe);

    Recipe remove(String id);

    List<Recipe> getAll();


}
