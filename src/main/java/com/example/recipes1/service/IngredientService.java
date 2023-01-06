package com.example.recipes1.service;

import com.example.recipes1.model.Ingredient;

import java.util.List;

public interface IngredientService {

    Ingredient add(Ingredient ingredient);

    Ingredient get(String id);

    Ingredient update (String id, Ingredient ingredient);

    Ingredient remove(String id);

    List<Ingredient> getAll();
}
