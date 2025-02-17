package com.leacooking.LeaCooking.api.dto.recipe;

import com.leacooking.LeaCooking.api.dto.recipepart.RecipePartDTO;
import lombok.Data;
import java.io.Serial;
import java.util.Set;

@Data
public class RecipeDTO {
    @Serial
    private static final long serialVersionUID = 1L;

    private long id;
    private String title;
    private long persons;
    private String imageUrl;
    private String recipeSubcategory;
    private Set<RecipePartDTO> recipeParts;
}
