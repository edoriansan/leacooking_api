package com.leacooking.LeaCooking.api.dto.recipepart;

import com.leacooking.LeaCooking.api.dto.recipepartingredient.RecipePartIngredientDTO;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Data
public class RecipePartDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String recipePartTitle;
    private String recipePartProcess;
    private Long recipeId;
    private Set<RecipePartIngredientDTO> recipePartIngredients;
}
