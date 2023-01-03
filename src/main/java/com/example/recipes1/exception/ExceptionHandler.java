package com.example.recipes1.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {


    public ResponseEntity<String> handRecipeNotFoundException(RecipeNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(String.format("Рецепт с id = %d ненайден!", e.getId()));
    }

    public ResponseEntity<String> handIngredientNotFoundException(IngredientNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(String.format("Ингредиент с id = %d ненайден!", e.getId()));
    }

}
