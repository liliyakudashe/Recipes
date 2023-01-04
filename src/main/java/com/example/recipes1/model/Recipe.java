package com.example.recipes1.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    private String nameOfTheRecipe;
    private int cookingTime;
    private List<Ingredient> listOfIngredients;
    private List<String> cookingSteps;
    private int id;
}
