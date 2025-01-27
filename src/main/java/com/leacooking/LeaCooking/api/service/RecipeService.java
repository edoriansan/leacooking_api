package com.leacooking.LeaCooking.api.service;

import com.leacooking.LeaCooking.api.config.error.ErrorEnum;
import com.leacooking.LeaCooking.api.dto.recipe.RecipeDTO;
import com.leacooking.LeaCooking.api.entity.Recipe;
import com.leacooking.LeaCooking.api.exception.ApiException;
import com.leacooking.LeaCooking.api.mapper.RecipeMapper;
import com.leacooking.LeaCooking.api.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper;

    @Transactional(rollbackFor = Exception.class)
    public Page<RecipeDTO> search(Pageable pageable, String search) throws ApiException {
        try {
            return recipeRepository.searchLight(pageable, search)
                    .map(recipeMapper::toDTO);
        } catch (Exception e) {
            throw new ApiException(e, ErrorEnum.E500);
        }
    }

    @Transactional(readOnly = true)
    public RecipeDTO getFullRecipe(Long recipeId) throws ApiException {
        try {
            Recipe recipe = recipeRepository.findRecipePartsAndIngredients(recipeId);
            return recipeMapper.toDTO(recipe);
        } catch (Exception e) {
            throw new ApiException(e, ErrorEnum.E500);
        }
    }
}
