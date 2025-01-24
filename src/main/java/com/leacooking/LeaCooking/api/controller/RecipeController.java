package com.leacooking.LeaCooking.api.controller;

import com.leacooking.LeaCooking.api.dto.recipe.RecipeDTO;
import com.leacooking.LeaCooking.api.exception.ApiException;
import com.leacooking.LeaCooking.api.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/recipe/")
public class RecipeController {

    private final RecipeService recipeService;

    @GetMapping("")
    public ResponseEntity<Page<RecipeDTO>> search(
            Pageable pageable,
            @RequestParam(required = false, name = "search") String search
    ) throws ApiException {
        return ResponseEntity.ok(this.recipeService.search(pageable, search));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<RecipeDTO> getRecipeById(@PathVariable Long id) throws ApiException {
        RecipeDTO recipeDTO = recipeService.getRecipeWithIngredients(id);
        return ResponseEntity.ok(recipeDTO);
    }
}
