package com.leacooking.LeaCooking.api.dto.recipe;

import com.leacooking.LeaCooking.api.dto.recipeingredient.RecipeIngredientDTO;
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
    private Integer persons;
    private String recipeImg;
    private Long recipeSubcategoryId;
    private Set<RecipeIngredientDTO> recipeIngredients;
}
