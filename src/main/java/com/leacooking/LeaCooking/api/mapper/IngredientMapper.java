package com.leacooking.LeaCooking.api.mapper;

import com.leacooking.LeaCooking.api.config.mapper.MapstructConfig;
import com.leacooking.LeaCooking.api.dto.ingredient.IngredientDTO;
import com.leacooking.LeaCooking.api.entity.Ingredient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapstructConfig.class)
public interface IngredientMapper {

    @Mapping(target = "recipePart", ignore = true)
    @Mapping(target = "quantity", ignore = true)
    @Mapping(source = "quantityType.label", target = "quantityTypeLabel")
    IngredientDTO toDTO(Ingredient ingredient);
}
