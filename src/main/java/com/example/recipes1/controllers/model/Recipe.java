package com.example.recipes1.controllers.model;
import java.util.*;

public class Recipe {
    private final String nameOfTheRecipe;
    private final int cookingTime;
    private List<Ingredient> listOfIngredients;
    private List<String> cookingSteps;
    private int id;

    public Recipe(String nameOfTheRecipe, int cookingTime, List<Ingredient> listOfIngredients, List<String> cookingSteps, int id) {
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
        return (ArrayList<Ingredient>) listOfIngredients;
    }

    public void setListOfIngredients(ArrayList<Ingredient> listOfIngredients) {
        this.listOfIngredients = listOfIngredients;
    }

    public void setListOfIngredients(List<Ingredient> listOfIngredients) {
        this.listOfIngredients = listOfIngredients;
    }

    public void setCookingSteps(List<String> cookingSteps) {
        this.cookingSteps = cookingSteps;
    }

    public List<String> getCookingSteps() {
        return cookingSteps;
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
