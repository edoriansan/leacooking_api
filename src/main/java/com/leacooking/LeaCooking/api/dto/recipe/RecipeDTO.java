package com.leacooking.LeaCooking.api.dto.recipe;

import com.leacooking.LeaCooking.api.dto.recipecategory.RecipeCategoryDTO;
import com.leacooking.LeaCooking.api.dto.recipeingredient.RecipeIngredientDTO;
import com.leacooking.LeaCooking.api.dto.recipesubcategory.RecipeSubcategoryDTO;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Data
public class RecipeDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;
    private String description;
    private Integer parts;
    private String recipeImg;
    private RecipeSubcategoryDTO recipeSubcategory;
    private Set<RecipeIngredientDTO> recipeIngredients;
}
