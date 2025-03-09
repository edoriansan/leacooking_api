package com.leacooking.LeaCooking.api.dto.recipepartingredient;

import lombok.Data;
import java.io.Serial;
import java.io.Serializable;

@Data
public class RecipePartIngredientDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long recipePartId;
    private Long ingredientId;
    private Integer quantity;
}
