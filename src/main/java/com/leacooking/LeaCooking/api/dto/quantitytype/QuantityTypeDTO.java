package com.leacooking.LeaCooking.api.dto.quantitytype;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class QuantityTypeDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String label;
}
