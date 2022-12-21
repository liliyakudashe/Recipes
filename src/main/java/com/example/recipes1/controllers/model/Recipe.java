package com.example.recipes1.controllers.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;


public class Recipe {
    private final String nameOfTheRecipe;
    private final int cookingTime;
    private ArrayList<Ingredient> listOfIngredients = new ArrayList<>();
    private Set<String> cookingSteps = new TreeSet<>();
    private int id;

    public Recipe(String nameOfTheRecipe, int cookingTime, ArrayList<Ingredient> listOfIngredients, Set<String> cookingSteps, int id) {
        this.nameOfTheRecipe = nameOfTheRecipe;
        this.cookingTime = cookingTime;
        this.listOfIngredients = listOfIngredients;
        this.cookingSteps = cookingSteps;
        this.id = id;
    }

    public String getNameOfTheRecipe() {
        return nameOfTheRecipe;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public ArrayList<Ingredient> getListOfIngredients() {
        return listOfIngredients;
    }

    public void setListOfIngredients(ArrayList<Ingredient> listOfIngredients) {
        this.listOfIngredients = listOfIngredients;
    }

    public Set<String> getCookingSteps() {
        return cookingSteps;
    }

    public void setCookingSteps(Set<String> cookingSteps) {
        this.cookingSteps = cookingSteps;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return cookingTime == recipe.cookingTime && id == recipe.id && Objects.equals(nameOfTheRecipe, recipe.nameOfTheRecipe) && Objects.equals(listOfIngredients, recipe.listOfIngredients) && Objects.equals(cookingSteps, recipe.cookingSteps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfTheRecipe, cookingTime, listOfIngredients, cookingSteps, id);
    }
}
