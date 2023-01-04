package com.example.recipes1.controllers;
import com.example.recipes1.model.Ingredient;
import com.example.recipes1.service.IngredientService;
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
@RequestMapping("/ingredient")
@Tag(name = "Ингредиенты", description = "CRUD и другие эндпоинты")
public class IngredientController {

    public final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }


    @GetMapping
    public List<Ingredient> getAll(){
        return this.ingredientService.getAll();
    }

    @Operation(summary = "Поиск ингредиента",description = "Нужно искать ингредиент по ID")
    @ApiResponses(value = {@ApiResponse(responseCode = "200",description = "Ингредиент найден", content = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Ingredient.class)))})})
    @GetMapping("/{id}")
    public Ingredient getIngredient(@PathVariable("id") String id){
        return ingredientService.get(id);
    }

    @PostMapping
    public ResponseEntity<?> addIngredient(@RequestBody Ingredient ingredient){
        if (StringUtils.isBlank(ingredient.getNameOfTheIngredient())){
            return ResponseEntity.badRequest().body("Необходимо добавить название рецепта");
        }
        return ResponseEntity.ok(ingredientService.add(ingredient));
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
