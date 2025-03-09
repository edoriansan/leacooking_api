package com.leacooking.LeaCooking.api.controller;

import com.leacooking.LeaCooking.api.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ingredient/")
public class IngredientController {

    private final IngredientService ingredientService;
}

