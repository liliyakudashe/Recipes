package com.example.recipes1.controllers;
import com.example.recipes1.model.Ingredient;
import com.example.recipes1.service.IngredientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/ingredient")
public class IngredientController {

    public final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public List<Ingredient> getAll(){
        return this.ingredientService.getAll();
    }

    @GetMapping("/{id}")
    public Ingredient getIngredient(@PathVariable("id") long id){
        return ingredientService.get(id);
    }

    @PutMapping
    public Ingredient addingAIngredient(@RequestBody Ingredient ingredient){
        return this.ingredientService.add(ingredient);
    }

    @PatchMapping("/{id}")
    public Ingredient update(@PathVariable("id") String id, @RequestBody Ingredient ingredient){
        return this.ingredientService.update(id, ingredient);
    }

    @DeleteMapping("/{id}")
    public Ingredient removeIngredient(@PathVariable("id") String id){
        return this.ingredientService.remove(id);
    }

}
