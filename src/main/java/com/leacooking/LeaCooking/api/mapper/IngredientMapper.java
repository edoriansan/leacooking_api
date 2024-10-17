package com.leacooking.LeaCooking.api.mapper;

import com.leacooking.LeaCooking.api.config.mapper.MapstructConfig;
import com.leacooking.LeaCooking.api.dto.ingredient.IngredientDTO;
import com.leacooking.LeaCooking.api.entity.Ingredient;
import com.leacooking.LeaCooking.api.entity.RecipeIngredient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapstructConfig.class)
public interface IngredientMapper {

    // Méthode pour mapper un Ingredient en IngredientDTO directement
    @Mapping(target = "recipePart", ignore = true)
    @Mapping(target = "quantity", ignore = true)
    @Mapping(source = "quantityType.label", target = "quantityTypeLabel")
    IngredientDTO toDTO(Ingredient ingredient);

    // Méthode pour mapper un RecipeIngredient en IngredientDTO, incluant la quantité et la partie de la recette
    @Mapping(source = "ingredient.id", target = "id")
    @Mapping(source = "ingredient.label", target = "label")
    @Mapping(source = "ingredientQuantity", target = "quantity")
    @Mapping(source = "recipePart.label", target = "recipePart")
    @Mapping(source = "ingredient.quantityType.label", target = "quantityTypeLabel")
    IngredientDTO toDTO(RecipeIngredient recipeIngredient);
}
