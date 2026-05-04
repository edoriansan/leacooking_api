package com.leacooking.LeaCooking.api.dto.recipe;

import com.leacooking.LeaCooking.api.dto.recipeingredient.RecipeIngredientRequestDTO;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Data
public class RecipeRequestDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String title;
    private String description;
    private Integer parts;
    private String recipeImg;
    private Long recipeSubcategoryId;
    private Set<RecipeIngredientRequestDTO> recipeIngredients;
}