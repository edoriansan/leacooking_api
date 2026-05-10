package com.leacooking.LeaCooking.api.controller;

import com.leacooking.LeaCooking.api.dto.recipe.RecipeRequestDTO;
import com.leacooking.LeaCooking.api.dto.recipe.RecipeResponseDTO;
import com.leacooking.LeaCooking.api.exception.ApiException;
import com.leacooking.LeaCooking.api.service.RecipeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    @PostMapping
    public ResponseEntity<RecipeResponseDTO> createRecipe(@RequestBody @Valid RecipeRequestDTO recipeToSave) {
        return ResponseEntity.ok(recipeService.saveRecipe(recipeToSave));
    }

    @GetMapping
    public ResponseEntity<List<RecipeResponseDTO>> getAllRecipes() throws ApiException {
        return ResponseEntity.ok(recipeService.getAllRecipes());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecipeResponseDTO> updateRecipe(@PathVariable Long id,
                                                          @RequestBody RecipeRequestDTO subcategoryToSave) throws ApiException {
        return ResponseEntity.ok(this.recipeService.updateRecipe(id, subcategoryToSave));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipeById(@PathVariable Long id) throws ApiException {
        this.recipeService.deleteRecipeById(id);
        return ResponseEntity.noContent().build();
    }
}
