package com.example.recipes1.controllers;

import com.example.recipes1.controllers.model.Ingredient;
import com.example.recipes1.controllers.service.IngredientService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController

public class FirstControiiers {

    @GetMapping
    public String theApplicationIsRunning() {
        return "Приложение запущено";
    }

    @GetMapping("/info")
    public String info(){
        return "Имя ученика - Лилия\n " +
                "Название проекта - книга рецептов\n " +
                "Дата создания проекта - 11 декабрь 2022 год\n " +
                "Описание проекта - сайт с рецептами";
    }

    @RestController
    @RequestMapping("/recipe")
    public static class IngredientController {


            private final IngredientService ingredientService;

            public IngredientController(IngredientService ingredientService){
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
}
