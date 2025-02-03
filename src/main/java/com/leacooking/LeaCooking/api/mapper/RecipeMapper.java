package com.leacooking.LeaCooking.api.mapper;

import com.leacooking.LeaCooking.api.config.mapper.MapstructConfig;
import com.leacooking.LeaCooking.api.dto.recipe.RecipeDTO;
import com.leacooking.LeaCooking.api.entity.Recipe;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(config = MapstructConfig.class, uses = { RecipePartMapper.class, RecipePartIngredientMapper.class })
public interface RecipeMapper {
    @Mapping(source = "recipeType.label", target = "recipeType")
    RecipeDTO toDTO(Recipe recipe);

    Set<RecipeDTO> toDTO(Set<Recipe> recipes);
}
