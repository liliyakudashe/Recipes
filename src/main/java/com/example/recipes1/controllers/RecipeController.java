package com.example.recipes1.controllers;
import com.example.recipes1.model.Recipe;
import com.example.recipes1.service.RecipeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService){
        this.recipeService = recipeService;
    }

    @GetMapping("/{id}")
    public Recipe getRecipe(@PathVariable("id") long id){
        return recipeService.get(id);
    }

    @GetMapping
    public List<Recipe> getAll(){
        return this.recipeService.getAll();
    }

    @PostMapping
    public ResponseEntity<?> addRecipe(@RequestBody Recipe recipe){
        if (StringUtils.isBlank(recipe.getNameOfTheRecipe())){
            return ResponseEntity.badRequest().body("Необходимо добавить название рецепта");
        }
        return ResponseEntity.ok(recipeService.add(recipe));
    }

    @PutMapping
    public Recipe addingARecipe(@RequestBody Recipe recipe){
        return this.recipeService.add(recipe);
    }

    @PatchMapping("/{id}")
    public Recipe updateRecipe(@PathVariable("id") long id, @RequestBody Recipe recipe){
        return this.recipeService.update(id, recipe);
    }

    @DeleteMapping("/{id}")
    public Recipe removeRecipe(@PathVariable("id") long id){
        return this.recipeService.remove(id);
    }

}
