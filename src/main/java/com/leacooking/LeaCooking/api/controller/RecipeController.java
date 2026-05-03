package com.leacooking.LeaCooking.api.controller;

import com.leacooking.LeaCooking.api.dto.recipe.RecipeDTO;
import com.leacooking.LeaCooking.api.dto.recipesubcategory.RecipeDTO;
import com.leacooking.LeaCooking.api.exception.ApiException;
import com.leacooking.LeaCooking.api.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/recipe/")
public class RecipeController {
    private final RecipeService recipeService;

    @PostMapping
    public ResponseEntity<RecipeDTO> createRecipe(@RequestBody RecipeDTO subcategoryToSave) throws ApiException {
        return ResponseEntity.ok(this.recipeService.saveRecipe(subcategoryToSave));
    }

    @GetMapping
    public ResponseEntity<List<RecipeDTO>> getAllRecipes() throws ApiException {
        return ResponseEntity.ok(recipeService.getAllRecipes());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecipeDTO> updateRecipe(@PathVariable Long id,
                                                  @RequestBody RecipeDTO subcategoryToSave) throws ApiException {
        return ResponseEntity.ok(this.recipeService.updateRecipe(id, subcategoryToSave));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipeById(@PathVariable Long id) throws ApiException {
        this.recipeService.deleteRecipeById(id);
        return ResponseEntity.noContent().build();
    }
}
