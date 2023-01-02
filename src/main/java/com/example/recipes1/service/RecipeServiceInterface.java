package com.example.recipes1.service;

import com.example.recipes1.model.Recipe;

import java.util.List;

public interface RecipeServiceInterface {

   Recipe add(Recipe recipe);

    Recipe get(long id);

    Recipe update (long id, Recipe recipe);

    Recipe remove(long id);

    List<Recipe> getAll();


}
