package com.leacooking.LeaCooking.api.mapper;

import com.leacooking.LeaCooking.api.config.mapper.MapstructConfig;
import com.leacooking.LeaCooking.api.dto.recipepart.RecipePartDTO;
import com.leacooking.LeaCooking.api.entity.RecipePart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapstructConfig.class, uses = {RecipePartIngredientMapper.class})
public interface RecipePartMapper {
    @Mapping(source = "recipePartIngredients", target = "ingredients")
    RecipePartDTO toDTO(RecipePart recipePart);
}
