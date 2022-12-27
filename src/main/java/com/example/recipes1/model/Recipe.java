package com.example.recipes1.model;
import lombok.Data;

import java.util.*;
@Data
public class Recipe {
    private final String nameOfTheRecipe;
    private final int cookingTime;
    private List<Ingredient> listOfIngredients;
    private List<String> cookingSteps;
    private int id;
}
