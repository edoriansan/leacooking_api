package com.leacooking.LeaCooking.api.service;

import com.leacooking.LeaCooking.api.config.error.ErrorEnum;
import com.leacooking.LeaCooking.api.dto.recipeingredient.RecipeIngredientDTO;
import com.leacooking.LeaCooking.api.entity.RecipeIngredient;
import com.leacooking.LeaCooking.api.exception.ApiException;
import com.leacooking.LeaCooking.api.mapper.RecipeIngredientMapper;
import com.leacooking.LeaCooking.api.repository.RecipeIngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RecipeIngredientService {
    private final RecipeIngredientRepository recipeIngredientRepository;
    private final RecipeIngredientMapper recipeIngredientMapper;

    @Transactional(readOnly = true)
    public List<RecipeIngredientDTO> findByRecipeId(Long recipeId) throws ApiException {
        try {
            return recipeIngredientRepository.findByRecipeId(recipeId).stream()
                    .map(recipeIngredientMapper::toDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new ApiException(e, ErrorEnum.E500);
        }
    }
}
