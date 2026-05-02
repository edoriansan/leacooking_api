package com.leacooking.LeaCooking.api.dto.recipesubcategory;

import com.leacooking.LeaCooking.api.dto.recipe.RecipeDTO;
import com.leacooking.LeaCooking.api.entity.Recipe;
import com.leacooking.LeaCooking.api.entity.RecipeCategory;
import lombok.Data;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Data
public class RecipeSubcategoryDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String recipeSubcategoryLabel;
    private String recipeSubcategoryImg;
    private Long recipeCategoryId;
    private Set<RecipeDTO> recipes;
    private RecipeCategory category;
}
