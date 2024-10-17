package com.leacooking.LeaCooking.api.dto.recipe;

import com.leacooking.LeaCooking.api.dto.recipeingredient.RecipeIngredientDTO;
import lombok.Getter;
import lombok.Setter;
import java.io.Serial;
import java.util.Set;

@Getter
@Setter
public class RecipeDTO {
    @Serial
    private static final long serialVersionUID = 1L;

    private long id;
    private String title;
    private String process;
    private long persons;
    private String imageUrl;
    private String recipeType;
    private Set<RecipeIngredientDTO> recipeIngredients;
}
