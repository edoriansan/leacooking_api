package com.leacooking.LeaCooking.api.service;

import com.leacooking.LeaCooking.api.mapper.RecipeMapper;
import com.leacooking.LeaCooking.api.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper;
}
