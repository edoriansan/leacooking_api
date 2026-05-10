package com.leacooking.LeaCooking.api.controller;

import com.leacooking.LeaCooking.api.dto.ingredient.IngredientDTO;
import com.leacooking.LeaCooking.api.exception.ApiException;
import com.leacooking.LeaCooking.api.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ingredient")
public class IngredientController {
    private final IngredientService ingredientService;

    @PostMapping
    public ResponseEntity<IngredientDTO> createIngredient(@RequestBody IngredientDTO ingredientToSave) throws ApiException {
        return ResponseEntity.ok(this.ingredientService.saveIngredient(ingredientToSave));
    }

    @GetMapping
    public ResponseEntity<List<IngredientDTO>> getAllIngredients() throws ApiException {
        return ResponseEntity.ok(this.ingredientService.getAllIngredients());
    }

    @PutMapping("/{id}")
    public ResponseEntity<IngredientDTO> updateIngredient(@PathVariable Long id,
                                                          @RequestBody IngredientDTO ingredientToSave) throws ApiException {
        return ResponseEntity.ok(this.ingredientService.updateIngredient(id, ingredientToSave));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngredientById(@PathVariable Long id) throws ApiException {
        this.ingredientService.deleteIngredientById(id);
        return ResponseEntity.noContent().build();
    }
}