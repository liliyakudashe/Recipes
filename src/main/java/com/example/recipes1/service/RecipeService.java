package com.example.recipes1.service;
import com.example.recipes1.model.Ingredient;
import com.example.recipes1.model.Recipe;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecipeService implements RecipeServiceInterface {
    private final Map<Long, Recipe> recipes = new HashMap<Long, Recipe>();
    private Long counter = 0L;
    
    final private FilesServiceRecipe filesServiceRecipe;

    public RecipeService(FilesServiceRecipe filesServiceRecipe) {
        this.filesServiceRecipe = filesServiceRecipe;
    }


    public Recipe add(Recipe recipe){
        recipes.put(this.counter++, recipe);
        saveToFile();
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

    private void saveToFile(){
        try {
           String json = new ObjectMapper().writeValueAsString(recipes);
           filesServiceRecipe.saveToFile(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @PostConstruct
    private void init(){
        readFromm();
    }
    private void readFromm(){
       String json = filesServiceRecipe.readFromFile();
        try {
            new ObjectMapper().readValue(json, new TypeReference<TreeMap<Ingredient, Recipe>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
