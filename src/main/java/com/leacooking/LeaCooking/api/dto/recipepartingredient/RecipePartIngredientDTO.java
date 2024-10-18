package com.leacooking.LeaCooking.api.dto.recipepartingredient;

import lombok.Getter;
import lombok.Setter;
import java.io.Serial;
import java.util.Set;

@Getter
@Setter
public class RecipePartIngredientDTO {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String label;
    private Set<RecipePartIngredientDTO> recipeIngredients;
}
