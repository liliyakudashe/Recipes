package com.example.recipes1.controllers;
import com.example.recipes1.controllers.model.Recipe;
import com.example.recipes1.controllers.service.RecipeService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService){
        this.recipeService = recipeService;
    }

    @GetMapping
    public Collection<Recipe> getAll(){
        return this.recipeService.getAll();
    }

    @PutMapping
    public Recipe addingARecipe(@RequestBody Recipe recipe){
        return this.recipeService.addRecipe(recipe);
    }

    @PatchMapping("/{id}")
    public Recipe updateRecipe(@PathVariable("id") String id, @RequestBody Recipe recipe){
        return this.recipeService.updateRecipe(id, recipe);
    }

    @DeleteMapping("/{id}")
    public Recipe removeRecipe(@PathVariable("id") String id){
        return this.recipeService.removeRecipe(id);
    }

}
