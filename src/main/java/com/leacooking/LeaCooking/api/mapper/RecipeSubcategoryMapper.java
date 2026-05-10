package com.leacooking.LeaCooking.api.mapper;

import com.leacooking.LeaCooking.api.dto.recipesubcategory.RecipeSubcategoryDTO;
import com.leacooking.LeaCooking.api.entity.RecipeSubcategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RecipeSubcategoryMapper {
    @Mapping(source = "recipeCategory.id", target = "recipeCategoryId")
    RecipeSubcategoryDTO toDTO(RecipeSubcategory entity);

    @Mapping(source = "recipeCategoryId", target = "recipeCategory.id")
    @Mapping(target = "recipes", ignore = true)
    RecipeSubcategory toEntity(RecipeSubcategoryDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "recipeCategoryId", target = "recipeCategory.id")
    @Mapping(target = "recipes", ignore = true)
    void fromDTO(RecipeSubcategoryDTO dto, @MappingTarget RecipeSubcategory entity);
}