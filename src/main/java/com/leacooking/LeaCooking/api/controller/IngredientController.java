package com.leacooking.LeaCooking.api.controller;

import com.leacooking.LeaCooking.api.dto.ingredient.IngredientDTO;
import com.leacooking.LeaCooking.api.exception.ApiException;
import com.leacooking.LeaCooking.api.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ingredient/")
public class IngredientController {

    private final IngredientService ingredientService;

    @GetMapping("")
    public ResponseEntity<Page<IngredientDTO>> search(
            Pageable pageable,
            @RequestParam(required = false, name = "search") String search
    ) throws ApiException {
        return ResponseEntity.ok(this.ingredientService.search(pageable, search));
    }
}

