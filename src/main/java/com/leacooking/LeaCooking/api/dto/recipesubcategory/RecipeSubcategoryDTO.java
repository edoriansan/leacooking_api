package com.leacooking.LeaCooking.api.dto.recipesubcategory;

import lombok.Data;
import java.io.Serial;
import java.io.Serializable;

@Data
public class RecipeSubcategoryDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String recipeSubcategoryLabel;
    private String recipeSubcategoryImg;
    private Long recipeCategoryId;
}
