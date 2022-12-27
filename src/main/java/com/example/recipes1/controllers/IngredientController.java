package com.example.recipes1.controllers;
import com.example.recipes1.model.Ingredient;
import com.example.recipes1.model.Recipe;
import com.example.recipes1.service.IngredientService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping
public class IngredientController {

    public final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public Collection<Ingredient> getAll(){
        return this.ingredientService.getAll();
    }

    @PutMapping
    public Ingredient addingAIngredient(@RequestBody Ingredient ingredient){
        return this.ingredientService.addIngredient(ingredient);
    }

    @PatchMapping("/{id}")
    public Ingredient updateIngredient(@PathVariable("id") String id, @RequestBody Ingredient ingredient){
        return this.ingredientService.updateIngredient(id, ingredient);
    }

    @DeleteMapping("/{id}")
    public Ingredient removeIngredient(@PathVariable("id") String id){
        return this.ingredientService.removeIngredient(id);
    }

}
