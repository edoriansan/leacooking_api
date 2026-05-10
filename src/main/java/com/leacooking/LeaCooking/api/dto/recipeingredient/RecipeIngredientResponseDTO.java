    package com.leacooking.LeaCooking.api.dto.recipeingredient;

    import lombok.Data;
    import java.io.Serial;
    import java.io.Serializable;

    @Data
    public class RecipeIngredientResponseDTO implements Serializable {
        @Serial
        private static final long serialVersionUID = 1L;

        private Long id;
        private Long recipeId;
        private Long ingredientId;
        private String quantity;
    }
