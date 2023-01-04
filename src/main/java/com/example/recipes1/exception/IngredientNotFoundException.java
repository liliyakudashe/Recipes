package com.example.recipes1.exception;

public class IngredientNotFoundException extends RuntimeException{

   private String id;

    public IngredientNotFoundException(String message) {
        super(message);
    }


    public String getId(){
        return id;
    }
}
