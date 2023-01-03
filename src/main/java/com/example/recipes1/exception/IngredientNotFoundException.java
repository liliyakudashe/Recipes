package com.example.recipes1.exception;

public class IngredientNotFoundException extends RuntimeException{

    private final long id;

    public IngredientNotFoundException(long id) {
        this.id = id;
    }

    public long getId(){
        return id;
    }
}
