package com.leacooking.LeaCooking.api.mapper;

import com.leacooking.LeaCooking.api.config.mapper.MapstructConfig;
import com.leacooking.LeaCooking.api.dto.ingredient.IngredientDTO;
import com.leacooking.LeaCooking.api.entity.Ingredient;
import org.mapstruct.Mapper;

@Mapper(config = MapstructConfig.class)
public interface IngredientMapper {
    IngredientDTO toDTO(Ingredient entity);
}
