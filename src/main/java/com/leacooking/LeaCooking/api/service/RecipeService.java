package com.leacooking.LeaCooking.api.service;

import com.leacooking.LeaCooking.api.config.error.ErrorEnum;
import com.leacooking.LeaCooking.api.dto.recipe.RecipeRequestDTO;
import com.leacooking.LeaCooking.api.dto.recipe.RecipeResponseDTO;
import com.leacooking.LeaCooking.api.entity.Recipe;
import com.leacooking.LeaCooking.api.entity.RecipeIngredient;
import com.leacooking.LeaCooking.api.exception.ApiException;
import com.leacooking.LeaCooking.api.mapper.RecipeIngredientMapper;
import com.leacooking.LeaCooking.api.mapper.RecipeMapper;
import com.leacooking.LeaCooking.api.mapper.RecipeSubcategoryMapper;
import com.leacooking.LeaCooking.api.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper;
    private final RecipeSubcategoryMapper recipeSubcategoryMapper;
    private final RecipeIngredientMapper recipeIngredientMapper;

    @Transactional(rollbackFor = Exception.class)
    public RecipeResponseDTO saveRecipe(RecipeRequestDTO recipeToSave) {
        Recipe recipe = recipeMapper.toEntity(recipeToSave);

        if (recipeToSave.getRecipeIngredients() != null) {
            Set<RecipeIngredient> ingredients = recipeToSave.getRecipeIngredients().stream()
                    .map(recipeIngredientMapper::toEntity)
                    .collect(Collectors.toSet());

            ingredients.forEach(ingredient -> ingredient.setRecipe(recipe));
            recipe.setRecipeIngredients(ingredients);
        }

        return recipeMapper.toDTO(recipeRepository.save(recipe));
    }

    @Transactional(readOnly = true)
    public List<RecipeResponseDTO> getAllRecipes() throws ApiException {
        List<Recipe> recipes = recipeRepository.findAll();

        if (recipes.isEmpty()) {
            throw new ApiException(ErrorEnum.E500, "No recipes found.");
        }

        return recipes.stream()
                .map(recipeMapper::toDTO)
                .toList();
    }

    @Transactional(rollbackFor = Exception.class)
    public RecipeResponseDTO updateRecipe(Long recipeId, RecipeRequestDTO recipeToSave) throws ApiException {
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new ApiException(ErrorEnum.E404, "No recipe found for id : " + recipeId));

        recipeMapper.fromDTO(recipeToSave, recipe);

        if (recipeToSave.getRecipeIngredients() != null) {
            recipe.getRecipeIngredients().clear();
            recipeRepository.saveAndFlush(recipe); // DELETE des anciens

            Set<RecipeIngredient> ingredients = recipeToSave.getRecipeIngredients().stream()
                    .map(recipeIngredientMapper::toEntity)
                    .collect(Collectors.toSet());

            ingredients.forEach(ingredient -> ingredient.setRecipe(recipe));
            recipe.getRecipeIngredients().addAll(ingredients);
        }

        return recipeMapper.toDTO(recipeRepository.save(recipe));
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteRecipeById(Long recipeId) throws ApiException {
        if (!recipeRepository.existsById(recipeId)) {
            throw new ApiException(ErrorEnum.E404, "No recipe not found for id : " + recipeId);
        }
        recipeRepository.deleteById(recipeId);
    }
}
