package com.leacooking.LeaCooking.api.mapper;

import com.leacooking.LeaCooking.api.config.mapper.MapstructConfig;
import com.leacooking.LeaCooking.api.dto.ingredient.IngredientDTO;
import com.leacooking.LeaCooking.api.entity.Ingredient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapstructConfig.class)
public interface IngredientMapper {
    @Mapping(source = "quantityType.id", target = "quantityTypeId")
    IngredientDTO toDTO(Ingredient ingredient);

    @Mapping(target = "recipePartIngredients", ignore = true)
    @Mapping(source = "quantityTypeId", target = "quantityType.id")
    Ingredient toEntity(IngredientDTO ingredientDTO);
}