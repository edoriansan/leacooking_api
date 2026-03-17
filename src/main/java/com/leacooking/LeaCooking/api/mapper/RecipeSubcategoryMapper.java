package com.leacooking.LeaCooking.api.mapper;

import com.leacooking.LeaCooking.api.dto.recipesubcategory.RecipeSubcategoryDTO;
import com.leacooking.LeaCooking.api.entity.RecipeSubcategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RecipeSubcategoryMapper {
    @Mapping(source = "recipeCategory.id", target = "recipeCategoryId")
    @Mapping(target = "recipeSubcategory.recipes", ignore = true)
    RecipeSubcategoryDTO toDTO(RecipeSubcategory subcategory);

    @Mapping(source = "recipeCategoryId", target = "recipeCategory.id")
    @Mapping(target = "recipes", ignore = true)
    RecipeSubcategory toEntity(RecipeSubcategoryDTO subcategoryDTO);
}
