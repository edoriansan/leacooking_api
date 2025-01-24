package com.leacooking.LeaCooking.api.mapper;

import com.leacooking.LeaCooking.api.config.mapper.MapstructConfig;
import com.leacooking.LeaCooking.api.dto.recipepartingredient.RecipePartIngredientDTO;
import com.leacooking.LeaCooking.api.entity.RecipePartIngredient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapstructConfig.class)
public interface RecipePartIngredientMapper {

    @Mapping(source = "ingredient.id", target = "ingredientId")
    @Mapping(source = "ingredient.label", target = "ingredientLabel")
    @Mapping(source = "quantity", target = "quantity")
    @Mapping(source = "ingredient.quantityType.label", target = "quantityTypeLabel")
    RecipePartIngredientDTO toDTO(RecipePartIngredient recipePartIngredient);
}
