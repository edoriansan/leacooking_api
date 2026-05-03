package com.leacooking.LeaCooking.api.service;

import com.leacooking.LeaCooking.api.config.error.ErrorEnum;
import com.leacooking.LeaCooking.api.dto.recipe.RecipeDTO;
import com.leacooking.LeaCooking.api.entity.Recipe;
import com.leacooking.LeaCooking.api.exception.ApiException;
import com.leacooking.LeaCooking.api.mapper.RecipeIngredientMapper;
import com.leacooking.LeaCooking.api.mapper.RecipeMapper;
import com.leacooking.LeaCooking.api.mapper.RecipeSubcategoryMapper;
import com.leacooking.LeaCooking.api.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper;
    private final RecipeSubcategoryMapper recipeSubcategoryMapper;
    private final RecipeIngredientMapper recipeIngredientMapper;

    @Transactional(rollbackFor = Exception.class)
    public RecipeDTO saveRecipe(RecipeDTO recipeToSave) {
        Recipe recipe  = recipeRepository.save(
                recipeMapper.toEntity(recipeToSave)
        );
        return recipeMapper.toDTO(recipe);
    }

    @Transactional(readOnly = true)
    public List<RecipeDTO> getAllRecipes() throws ApiException {
        List<Recipe> recipes = recipeRepository.findAll();

        if (recipes.isEmpty()) {
            throw new ApiException(ErrorEnum.E500, "No recipes found.");
        }

        return recipes.stream()
                .map(recipeMapper::toDTO)
                .toList();
    }

    @Transactional(rollbackFor = Exception.class)
    public RecipeDTO updateRecipe(Long recipeId, RecipeDTO recipeToSave) throws ApiException {
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new ApiException(ErrorEnum.E404, "No recipe not found for id : " + recipeId));

        recipeMapper.fromDTO(recipeToSave, recipe);

        if (recipeToSave.getRecipeIngredients() != null) {
            recipe.setRecipeIngredients(
                    recipeToSave.getRecipeIngredients().stream()
                            .map(recipeIngredientMapper::toEntity)
                            .collect(Collectors.toSet())
            );
        }

        Recipe updatedRecipe = recipeRepository.save(recipe);

        return recipeMapper.toDTO(updatedRecipe);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteRecipeById(Long recipeId) throws ApiException {
        if (!recipeRepository.existsById(recipeId)) {
            throw new ApiException(ErrorEnum.E404, "No recipe not found for id : " + recipeId);
        }
        recipeRepository.deleteById(recipeId);
    }
}
