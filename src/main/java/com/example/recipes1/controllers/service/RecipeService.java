package com.example.recipes1.controllers.service;

import com.example.recipes1.controllers.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecipeService {
    private final Map<String, Recipe> recipes = new TreeMap<>();

    public Recipe addRecipe(Recipe recipe){
        recipes.put(recipe.getNameOfTheRecipe(),recipe);
        return recipe;
    }

    public Recipe getReceiving(String id){
        if (recipes.containsKey(id)){
            return recipes.get(id);
        } else {
            throw new RuntimeException();
        }
    }

    public Recipe updateRecipe (String id, Recipe recipe){
        Recipe serviceRecipe = recipes.get(id);
        if (serviceRecipe == null){
            throw new RuntimeException("Такого рецепта нет");
        }
        serviceRecipe.setCookingSteps(recipe.getCookingSteps());
        serviceRecipe.setListOfIngredients(recipe.getListOfIngredients());
        return serviceRecipe;
    }

    public Recipe removeRecipe(String id){
        return recipes.remove(id);
    }

    public Collection<Recipe> getAll(){
        return recipes.values();
    }
}
