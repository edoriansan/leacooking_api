package com.leacooking.LeaCooking.api.dto.ingredient;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;

@Getter
@Setter
public class IngredientDTO {
    @Serial
    private static final long serialVersionUID = 1L;

    private long id;
    private String label;
}
