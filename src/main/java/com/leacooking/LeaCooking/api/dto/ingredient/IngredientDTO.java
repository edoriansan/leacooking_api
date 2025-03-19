package com.leacooking.LeaCooking.api.dto.ingredient;

import lombok.Data;
import java.io.Serial;
import java.io.Serializable;

@Data
public class IngredientDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private long id;
    private String label;
}
