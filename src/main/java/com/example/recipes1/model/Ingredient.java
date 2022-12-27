package com.example.recipes1.model;
import lombok.Data;

import java.util.Objects;
@Data
public class Ingredient {
    private final String nameOfTheIngredient;
    private final int numberOfIngredients;
    private final String unitOfMeasurement;
}
