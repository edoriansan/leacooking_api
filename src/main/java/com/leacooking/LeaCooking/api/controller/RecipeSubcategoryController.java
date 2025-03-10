package com.leacooking.LeaCooking.api.controller;

import com.leacooking.LeaCooking.api.dto.recipesubcategory.RecipeSubcategoryDTO;
import com.leacooking.LeaCooking.api.exception.ApiException;
import com.leacooking.LeaCooking.api.service.RecipeSubcategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/subcategory/")
public class RecipeSubcategoryController {

    private final RecipeSubcategoryService recipeSubcategoryService;

    @GetMapping
    public ResponseEntity<List<RecipeSubcategoryDTO>> getAllSubcategories() throws ApiException {
        List<RecipeSubcategoryDTO> subcategories = recipeSubcategoryService.getAllSubcategories();
        return ResponseEntity.ok(subcategories);
    }
}
