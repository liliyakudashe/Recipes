package com.example.recipes1.service;
import com.example.recipes1.model.Ingredient;
import com.example.recipes1.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class IngredientService {

    private final Map<String, Ingredient> ingredients = new TreeMap<>();

    public Ingredient add(Ingredient ingredient){
        ingredients.put(ingredient.getNameOfTheIngredient(),ingredient);
        return ingredient;
    }

    public Ingredient get(long id){
        if (ingredients.containsKey(id)){
            return ingredients.get(id);
        } else {
            throw new RuntimeException();
        }
    }
    public Ingredient update (String id, Ingredient ingredient){
        Ingredient serviceIngredient = ingredients.get(id);
        if (serviceIngredient == null){
            throw new RuntimeException("Такого рецепта нет");
        }
        return serviceIngredient;
    }

    public Ingredient remove(String id){
        return ingredients.remove(id);
    }

    public List<Ingredient> getAll(){
        return new ArrayList<>();
    }

}
