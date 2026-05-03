package com.leacooking.LeaCooking.api.controller;

import com.leacooking.LeaCooking.api.dto.recipecategory.RecipeCategoryDTO;
import com.leacooking.LeaCooking.api.exception.ApiException;
import com.leacooking.LeaCooking.api.service.RecipeCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
public class RecipeCategoryController {

    private final RecipeCategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<RecipeCategoryDTO>> getAllCategories() throws ApiException {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }
}
