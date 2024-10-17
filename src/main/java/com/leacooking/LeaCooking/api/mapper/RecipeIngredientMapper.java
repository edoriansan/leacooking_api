package com.leacooking.LeaCooking.api.mapper;

import com.leacooking.LeaCooking.api.dto.recipeingredient.RecipeIngredientDTO;
import com.leacooking.LeaCooking.api.entity.RecipeIngredient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface RecipeIngredientMapper {
    @Mapping(source = "ingredient.id", target = "ingredientId")
    @Mapping(source = "ingredient.label", target = "ingredientLabel")
    @Mapping(source = "ingredientQuantity", target = "quantity")
    @Mapping(source = "recipePart.label", target = "recipePartLabel")
    RecipeIngredientDTO toDTO(RecipeIngredient recipeIngredient);
}
