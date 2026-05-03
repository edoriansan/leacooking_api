package com.leacooking.LeaCooking.api.mapper;

import com.leacooking.LeaCooking.api.config.mapper.MapstructConfig;
import com.leacooking.LeaCooking.api.dto.recipe.RecipeDTO;
import com.leacooking.LeaCooking.api.entity.Recipe;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = MapstructConfig.class, uses = { RecipeIngredientMapper.class, RecipeSubcategoryMapper.class })
public interface RecipeMapper {
    @Mapping(source = "recipeSubcategory.id", target = "recipeSubcategoryId")
    RecipeDTO toDTO(Recipe recipe);

    @Mapping(source = "recipeSubcategoryId", target = "recipeSubcategory.id")
    Recipe toEntity(RecipeDTO recipeDTO);

    @Mapping(source = "recipeSubcategoryId", target = "recipeSubcategory.id")
    @Mapping(target = "recipeIngredients", ignore = true)
    void fromDTO(RecipeDTO dto, @MappingTarget Recipe entity);
}
