package com.leacooking.LeaCooking.api.service;

import com.leacooking.LeaCooking.api.mapper.IngredientMapper;
import com.leacooking.LeaCooking.api.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;
    private final IngredientMapper ingredientMapper;
}
