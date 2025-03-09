package com.leacooking.LeaCooking.api.mapper;

import com.leacooking.LeaCooking.api.config.mapper.MapstructConfig;
import com.leacooking.LeaCooking.api.dto.recipe.RecipeDTO;
import com.leacooking.LeaCooking.api.entity.Recipe;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapstructConfig.class, uses = { RecipePartMapper.class, RecipePartIngredientMapper.class })
public interface RecipeMapper {
    @Mapping(source = "recipeSubcategory.id", target = "recipeSubcategoryId")
    RecipeDTO toDTO(Recipe recipe);

    @Mapping(source = "recipeSubcategoryId", target = "recipeSubcategory.id")
    Recipe toEntity(RecipeDTO recipeDTO);
}
