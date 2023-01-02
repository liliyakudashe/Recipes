package com.example.recipes1.service;

import com.example.recipes1.model.Ingredient;

import java.util.List;

public interface IngredientServiceInterface {

    Ingredient add(Ingredient ingredient);

    Ingredient get(long id);

    Ingredient update (String id, Ingredient ingredient);

    Ingredient remove(String id);

    List<Ingredient> getAll();
}
