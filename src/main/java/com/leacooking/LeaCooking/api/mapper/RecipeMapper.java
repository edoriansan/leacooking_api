package com.leacooking.LeaCooking.api.mapper;

import com.leacooking.LeaCooking.api.config.mapper.MapstructConfig;
import com.leacooking.LeaCooking.api.dto.recipe.RecipeDTO;
import com.leacooking.LeaCooking.api.entity.Recipe;
import org.mapstruct.Mapper;

@Mapper(config = MapstructConfig.class)
public interface RecipeMapper {
    RecipeDTO toDTO(Recipe entity);
}
