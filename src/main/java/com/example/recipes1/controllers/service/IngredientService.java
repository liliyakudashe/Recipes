package com.example.recipes1.controllers.service;
import com.example.recipes1.controllers.model.Ingredient;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

@Service
public class IngredientService {

    private final Map<String, Ingredient> ingredients = new TreeMap<>();

    public Ingredient addIngredient(Ingredient ingredient){
        ingredients.put(ingredient.getNameOfTheIngredient(),ingredient);
        return ingredient;
    }

    public Ingredient updateIngredient (String id, Ingredient ingredient){
        Ingredient serviceIngredient = ingredients.get(id);
        if (serviceIngredient == null){
            throw new RuntimeException("Такого рецепта нет");
        }
        return serviceIngredient;
    }

    public Ingredient removeIngredient(String id){
        return ingredients.remove(id);
    }

    public Collection<Ingredient> getAll(){
        return ingredients.values();
    }

}
