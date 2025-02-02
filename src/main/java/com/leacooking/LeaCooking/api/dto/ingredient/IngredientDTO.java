package com.leacooking.LeaCooking.api.dto.ingredient;

import lombok.Getter;
import lombok.Setter;
import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class IngredientDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private long id;
    private String label;
    private String recipePart;
    private long quantity;
    private String quantityTypeLabel;
}
