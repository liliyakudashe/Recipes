package com.example.recipes1.controllers.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@AllArgsConstructor

public class Ingredient {
    private final String nameOfTheIngredient;
    private final int numberOfIngredients;
    private final String unitOfMeasurement;

    public Ingredient(String nameOfTheIngredient, int numberOfIngredients, String unitOfMeasurement) {
        this.nameOfTheIngredient = nameOfTheIngredient;
        this.numberOfIngredients = numberOfIngredients;
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public String getNameOfTheIngredient() {
        return nameOfTheIngredient;
    }

    public int getNumberOfIngredients() {
        return numberOfIngredients;
    }

    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return numberOfIngredients == that.numberOfIngredients && Objects.equals(nameOfTheIngredient, that.nameOfTheIngredient) && Objects.equals(unitOfMeasurement, that.unitOfMeasurement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfTheIngredient, numberOfIngredients, unitOfMeasurement);
    }

}
