package com.example.recipes1.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {
    private String nameOfTheIngredient;
    private int numberOfIngredients;
    private String unitOfMeasurement;
}
