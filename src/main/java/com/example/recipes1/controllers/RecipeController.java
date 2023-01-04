package com.example.recipes1.controllers;
import com.example.recipes1.model.Recipe;
import com.example.recipes1.service.RecipeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipe")
@Tag(name = "Рецепты", description = "CRUD и другие эндпоинты")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService){
        this.recipeService = recipeService;
    }

    @Operation(summary = "Поиск рецепта",description = "Нужно искать рецепт по ID")
    @ApiResponses(value = {@ApiResponse(responseCode = "200",description = "Рецепт найден", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Recipe.class)))})})
    @GetMapping("/{id}")
    public Recipe getRecipe(@PathVariable("id") String id){
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
    public Recipe updateRecipe(@PathVariable("id") String id, @RequestBody Recipe recipe){
        return this.recipeService.update(id, recipe);
    }

    @DeleteMapping("/{id}")
    public Recipe removeRecipe(@PathVariable("id") String id){
        return this.recipeService.remove(id);
    }

}
