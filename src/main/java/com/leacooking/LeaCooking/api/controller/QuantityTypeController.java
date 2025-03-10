package com.leacooking.LeaCooking.api.controller;

import com.leacooking.LeaCooking.api.dto.quantitytype.QuantityTypeDTO;
import com.leacooking.LeaCooking.api.exception.ApiException;
import com.leacooking.LeaCooking.api.service.QuantityTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/quantity-types/")
public class QuantityTypeController {

    private final QuantityTypeService quantityTypeService;

    @GetMapping
    public ResponseEntity<List<QuantityTypeDTO>> getAllQuantityTypes() throws ApiException {
        List<QuantityTypeDTO> quantityTypes = quantityTypeService.getAllQuantityTypes();
        return ResponseEntity.ok(quantityTypes);
    }
}
