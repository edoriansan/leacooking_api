package com.leacooking.LeaCooking.api.mapper;

import com.leacooking.LeaCooking.api.config.mapper.MapstructConfig;
import com.leacooking.LeaCooking.api.dto.recipepartingredient.RecipePartIngredientDTO;
import com.leacooking.LeaCooking.api.entity.RecipePartIngredient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapstructConfig.class)
public interface RecipePartIngredientMapper {
    @Mapping(source = "recipePart.id", target = "recipePartId")
    @Mapping(source = "ingredient.id", target = "ingredientId")
    RecipePartIngredientDTO toDTO(RecipePartIngredient recipePartIngredient);

    @Mapping(source = "recipePartId", target = "recipePart.id")
    @Mapping(source = "ingredientId", target = "ingredient.id")
    RecipePartIngredient toEntity(RecipePartIngredientDTO recipePartIngredientDTO);
}
