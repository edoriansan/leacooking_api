package com.leacooking.LeaCooking.api.mapper;

import com.leacooking.LeaCooking.api.config.mapper.MapstructConfig;
import com.leacooking.LeaCooking.api.dto.recipe.RecipeRequestDTO;
import com.leacooking.LeaCooking.api.dto.recipe.RecipeResponseDTO;
import com.leacooking.LeaCooking.api.entity.Recipe;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = MapstructConfig.class, uses = { RecipeIngredientMapper.class, RecipeSubcategoryMapper.class })
public interface RecipeMapper {
    @Mapping(source = "recipeSubcategory.id", target = "recipeSubcategoryId")
    RecipeResponseDTO toDTO(Recipe recipe);

    @Mapping(source = "recipeSubcategoryId", target = "recipeSubcategory.id")
    @Mapping(target = "id", ignore = true)
    Recipe toEntity(RecipeRequestDTO recipeRequestDTO);

    @Mapping(source = "recipeSubcategoryId", target = "recipeSubcategory.id")
    @Mapping(target = "recipeIngredients", ignore = true)
    @Mapping(target = "id", ignore = true)
    void fromDTO(RecipeRequestDTO dto, @MappingTarget Recipe entity);
}
