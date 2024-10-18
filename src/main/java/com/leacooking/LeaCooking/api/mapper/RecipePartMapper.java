package com.leacooking.LeaCooking.api.mapper;

import com.leacooking.LeaCooking.api.config.mapper.MapstructConfig;
import com.leacooking.LeaCooking.api.dto.recipepart.RecipePartDTO;
import com.leacooking.LeaCooking.api.entity.RecipePart;
import org.mapstruct.Mapper;

@Mapper(config = MapstructConfig.class)
public interface RecipePartMapper {
    RecipePartDTO toDTO(RecipePart recipePart);
}
