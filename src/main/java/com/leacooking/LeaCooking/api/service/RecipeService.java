package com.leacooking.LeaCooking.api.service;

import com.leacooking.LeaCooking.api.config.error.ErrorEnum;
import com.leacooking.LeaCooking.api.dto.recipe.RecipeDTO;
import com.leacooking.LeaCooking.api.entity.Recipe;
import com.leacooking.LeaCooking.api.exception.ApiException;
import com.leacooking.LeaCooking.api.mapper.RecipeMapper;
import com.leacooking.LeaCooking.api.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper;

    public List<RecipeDTO> getAllRecipes() throws ApiException {
        List<Recipe> recipes = recipeRepository.findAll();

        if (recipes.isEmpty()) {
            throw new ApiException(ErrorEnum.E500, "No recipes found.");
        }

        return recipes.stream()
                .map(recipeMapper::toDTO)
                .toList();
    }
}
