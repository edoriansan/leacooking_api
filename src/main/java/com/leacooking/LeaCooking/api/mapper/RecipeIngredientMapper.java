package com.leacooking.LeaCooking.api.mapper;

import com.leacooking.LeaCooking.api.config.mapper.MapstructConfig;
import com.leacooking.LeaCooking.api.dto.recipeingredient.RecipeIngredientRequestDTO;
import com.leacooking.LeaCooking.api.dto.recipeingredient.RecipeIngredientResponseDTO;
import com.leacooking.LeaCooking.api.entity.RecipeIngredient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapstructConfig.class)
public interface RecipeIngredientMapper {
    @Mapping(source = "ingredient.id", target = "ingredientId")
    @Mapping(source = "recipe.id", target = "recipeId")
    RecipeIngredientResponseDTO toDTO(RecipeIngredient entity);

    @Mapping(source = "ingredientId", target = "ingredient.id")
    @Mapping(target = "recipe", ignore = true)
    RecipeIngredient toEntity(RecipeIngredientRequestDTO dto);
}
