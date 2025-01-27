package com.leacooking.LeaCooking.api.dto.recipepart;

import com.leacooking.LeaCooking.api.dto.recipepartingredient.RecipePartIngredientDTO;
import lombok.Data;

import java.io.Serial;
import java.util.Set;

@Data
public class RecipePartDTO {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String recipePartTitle;
    private String process;
    private Set<RecipePartIngredientDTO> ingredients;
}
