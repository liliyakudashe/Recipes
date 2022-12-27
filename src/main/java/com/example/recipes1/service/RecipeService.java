package com.example.recipes1.service;
import com.example.recipes1.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecipeService {
    private final Map<Long, Recipe> recipes = new HashMap<Long, Recipe>();
    private Long counter = 0L;

    public Recipe add(Recipe recipe){
        recipes.put(this.counter++, recipe);
        return recipe;
    }

    public Recipe get(long id){
        if (recipes.containsKey(id)){
            return recipes.get(id);
        } else {
            throw new RuntimeException();
        }
    }

    public Recipe update (long id, Recipe recipe){
        Recipe serviceRecipe = recipes.get(id);
        if (serviceRecipe == null){
            throw new RuntimeException("Такого рецепта нет");
        }
        serviceRecipe.setCookingSteps(recipe.getCookingSteps());
        serviceRecipe.setListOfIngredients(recipe.getListOfIngredients());
        return serviceRecipe;
    }

    public Recipe remove(long id){
        return recipes.remove(id);
    }

    public List<Recipe> getAll(){
        return new ArrayList<>();
    }
}
