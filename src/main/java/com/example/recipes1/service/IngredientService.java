package com.example.recipes1.service;
import com.example.recipes1.exception.IngredientNotFoundException;
import com.example.recipes1.model.Ingredient;
import com.example.recipes1.model.Recipe;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class IngredientService implements IngredientServiceInterface {

    private final Map<String, Ingredient> ingredients = new TreeMap<>();

    final private FilesServiceRecipe filesService;

    public IngredientService(FilesServiceRecipe filesServiceRecipe) {
        this.filesService = filesServiceRecipe;
    }

    public Ingredient add(Ingredient ingredient){
        ingredients.put(ingredient.getNameOfTheIngredient(),ingredient);
        return ingredient;
    }

    public Ingredient get(long id){
        if (ingredients.containsKey(id)){
            return ingredients.get(id);
        } else {
            throw new IngredientNotFoundException(id);
        }
    }
    public Ingredient update (long id, Ingredient ingredient){
        Ingredient serviceIngredient = ingredients.get(id);
        if (serviceIngredient == null){
            throw new IngredientNotFoundException(id);
        }
        return serviceIngredient;
    }

    public Ingredient remove(String id){
        return ingredients.remove(id);
    }

    public List<Ingredient> getAll(){
        return new ArrayList<>();
    }

    private void saveToFile(){
        try {
            String json = new ObjectMapper().writeValueAsString(ingredients);
            filesService.saveToFile(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @PostConstruct
    private void init(){
        readFromm();
    }
    private void readFromm(){
        String json = filesService.readFromFile();
        try {
            new ObjectMapper().readValue(json, new TypeReference<TreeMap<Ingredient, Recipe>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
