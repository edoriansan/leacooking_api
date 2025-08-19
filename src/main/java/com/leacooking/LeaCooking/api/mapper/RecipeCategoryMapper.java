package com.leacooking.LeaCooking.api.mapper;

import com.leacooking.LeaCooking.api.config.mapper.MapstructConfig;
import com.leacooking.LeaCooking.api.dto.recipecategory.RecipeCategoryDTO;
import com.leacooking.LeaCooking.api.entity.RecipeCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapstructConfig.class)
public interface RecipeCategoryMapper {
    RecipeCategoryDTO toDTO(RecipeCategory category);

    @Mapping(target = "recipeSubcategories", ignore = true)
    RecipeCategory toEntity(RecipeCategoryDTO categoryDTO);
}
