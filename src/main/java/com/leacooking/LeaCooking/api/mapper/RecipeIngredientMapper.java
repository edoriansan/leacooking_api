package com.leacooking.LeaCooking.api.mapper;

import com.leacooking.LeaCooking.api.config.mapper.MapstructConfig;
import com.leacooking.LeaCooking.api.dto.recipeingredient.RecipeIngredientDTO;
import com.leacooking.LeaCooking.api.entity.RecipeIngredient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapstructConfig.class)
public interface RecipeIngredientMapper {
    @Mapping(source = "recipe.id", target = "recipeId")
    @Mapping(source = "ingredient.id", target = "ingredientId")
    RecipeIngredientDTO toDTO(RecipeIngredient recipeIngredient);

    @Mapping(source = "recipeId", target = "recipe.id")
    @Mapping(source = "ingredientId", target = "ingredient.id")
    RecipeIngredient toEntity(RecipeIngredientDTO recipeIngredientDTO);
}
