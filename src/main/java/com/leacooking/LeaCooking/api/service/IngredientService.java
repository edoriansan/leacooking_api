package com.leacooking.LeaCooking.api.service;

import com.leacooking.LeaCooking.api.config.error.ErrorEnum;
import com.leacooking.LeaCooking.api.dto.ingredient.IngredientDTO;
import com.leacooking.LeaCooking.api.entity.Ingredient;
import com.leacooking.LeaCooking.api.exception.ApiException;
import com.leacooking.LeaCooking.api.mapper.IngredientMapper;
import com.leacooking.LeaCooking.api.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;
    private final IngredientMapper ingredientMapper;

    public List<IngredientDTO> getAllIngredients() throws ApiException {
        List<Ingredient> ingredients = ingredientRepository.findAll();

        if (ingredients.isEmpty()) {
            throw new ApiException(ErrorEnum.E500, "No ingredients found.");
        }

        return ingredients.stream()
                .map(ingredientMapper::toDTO)
                .collect(Collectors.toList());
    }
}
