package com.leacooking.LeaCooking.api.mapper;

import com.leacooking.LeaCooking.api.config.mapper.MapstructConfig;
import com.leacooking.LeaCooking.api.dto.ingredient.IngredientDTO;
import com.leacooking.LeaCooking.api.entity.Ingredient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = MapstructConfig.class)
public interface IngredientMapper {
    IngredientDTO toDTO(Ingredient ingredient);

    @Mapping(target = "recipeIngredients", ignore = true)
    Ingredient toEntity(IngredientDTO ingredientDTO);

    @Mapping(target = "recipeIngredients", ignore = true)
    @Mapping(target = "id", ignore = true)
    void fromDTO(IngredientDTO ingredientDTO, @MappingTarget Ingredient ingredient);
}
