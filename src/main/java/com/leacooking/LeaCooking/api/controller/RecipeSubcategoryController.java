package com.leacooking.LeaCooking.api.controller;

import com.leacooking.LeaCooking.api.dto.recipesubcategory.RecipeSubcategoryDTO;
import com.leacooking.LeaCooking.api.exception.ApiException;
import com.leacooking.LeaCooking.api.service.RecipeSubcategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/subcategory")
public class RecipeSubcategoryController {

    private final RecipeSubcategoryService recipeSubcategoryService;
    
    @PostMapping
    public ResponseEntity<RecipeSubcategoryDTO> createSubcategory(@RequestBody RecipeSubcategoryDTO subcategoryToSave) throws ApiException {
        return ResponseEntity.ok(this.recipeSubcategoryService.saveSubcategory(subcategoryToSave));
    }

    @GetMapping
    public ResponseEntity<List<RecipeSubcategoryDTO>> getAllSubcategories() throws ApiException {
        return ResponseEntity.ok(recipeSubcategoryService.getAllSubcategories());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecipeSubcategoryDTO> updateSubcategory(@PathVariable Long id,
                                                                  @RequestBody RecipeSubcategoryDTO subcategoryToSave) throws ApiException {
        return ResponseEntity.ok(this.recipeSubcategoryService.updateSubcategory(id, subcategoryToSave));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubcategoryById(@PathVariable Long id) throws ApiException {
        this.recipeSubcategoryService.deleteSubcategoryById(id);
        return ResponseEntity.noContent().build();
    }
}
