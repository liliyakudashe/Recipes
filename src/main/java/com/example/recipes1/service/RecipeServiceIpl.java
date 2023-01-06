package com.example.recipes1.service;
import com.example.recipes1.exception.RecipeNotFoundException;
import com.example.recipes1.model.Ingredient;
import com.example.recipes1.model.Recipe;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecipeServiceIpl implements RecipeService {
    private final Map<Long, Recipe> recipes = new HashMap<Long, Recipe>();
    private Long counter = 0L;
    
    final private FilesServiceRecipeIpl filesServiceRecipe;

    public RecipeServiceIpl(FilesServiceRecipeIpl filesServiceRecipe) {
        this.filesServiceRecipe = filesServiceRecipe;
    }


    public Recipe add(Recipe recipe){
        recipes.put(this.counter++, recipe);
        saveToFile();
        return recipe;
    }

    public Recipe get(String id){
        if (recipes.containsKey(id)){
            return recipes.get(id);
        } else {
            throw new RecipeNotFoundException(id);
        }
    }

    public Recipe update (String id, Recipe recipe){
        Recipe serviceRecipe = recipes.get(id);
        if (serviceRecipe == null){
            throw new RecipeNotFoundException("Рецепт с id =" + id + " %d не найден!");
        }
        serviceRecipe.setCookingSteps(recipe.getCookingSteps());
        serviceRecipe.setListOfIngredients(recipe.getListOfIngredients());
        return serviceRecipe;
    }

    public Recipe remove(String id){
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
            throw new RecipeNotFoundException("Файл не найден " + e);
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
            throw new RecipeNotFoundException("Файл не найден " + e);
        }
    }
}