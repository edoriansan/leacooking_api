package com.leacooking.LeaCooking.api.dto.recipepartingredient;

import lombok.Data;
import java.io.Serial;

@Data
public class RecipePartIngredientDTO {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long ingredientId;
    private String ingredientLabel;
    private Integer quantity;
    private String quantityTypeLabel;
}
