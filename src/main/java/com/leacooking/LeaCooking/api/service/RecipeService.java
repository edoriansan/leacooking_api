package com.leacooking.LeaCooking.api.service;

import com.leacooking.LeaCooking.api.config.error.ErrorEnum;
import com.leacooking.LeaCooking.api.dto.recipe.RecipeDTO;
import com.leacooking.LeaCooking.api.dto.recipeingredient.RecipeIngredientDTO;
import com.leacooking.LeaCooking.api.entity.Recipe;
import com.leacooking.LeaCooking.api.exception.ApiException;
import com.leacooking.LeaCooking.api.mapper.RecipeMapper;
import com.leacooking.LeaCooking.api.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper;
    private final RecipeIngredientService recipeIngredientService;

    @Transactional(rollbackFor = Exception.class)
    public Page<RecipeDTO> search(Pageable pageable, String search) throws ApiException {
        try {
            return this.recipeRepository.searchLight(pageable, search)
                    .map(recipeMapper::toDTO); // Conversion en DTO sans ingrédients
        } catch (Exception e) {
            throw new ApiException(e, ErrorEnum.E500);
        }
    }

    @Transactional(readOnly = true)
    public RecipeDTO getRecipeWithIngredients(Long recipeId) throws ApiException {
        try {
            Recipe recipe = recipeRepository.findById(recipeId)
                    .orElseThrow(() -> new ApiException(ErrorEnum.E500));

            RecipeDTO recipeDTO = recipeMapper.toDTO(recipe);

            Set<RecipeIngredientDTO> ingredients = recipeIngredientService
                    .findByRecipeId(recipeId)
                    .stream()
                    .collect(Collectors.toSet());

            recipeDTO.setRecipeIngredients(ingredients);

            return recipeDTO;
        } catch (Exception e) {
            throw new ApiException(e, ErrorEnum.E500);
        }
    }
}
