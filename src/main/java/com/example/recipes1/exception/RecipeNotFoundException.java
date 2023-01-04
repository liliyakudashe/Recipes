package com.example.recipes1.exception;

public class RecipeNotFoundException extends RuntimeException{

    private String id;

    public RecipeNotFoundException(String message) {
        super(message);
    }

    public String getId() {
        return id;
    }
}
