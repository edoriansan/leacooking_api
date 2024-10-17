package com.leacooking.LeaCooking.api.dto.recipeingredient;

import lombok.Getter;
import lombok.Setter;
import java.io.Serial;

@Getter
@Setter
public class RecipeIngredientDTO {
    @Serial
    private static final long serialVersionUID = 1L;

    private long ingredientId;
    private String ingredientLabel;
    private long quantity;
    private String quantityTypeLabel;
    private String recipePartLabel;
}
