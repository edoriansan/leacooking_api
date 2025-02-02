package com.leacooking.LeaCooking.api.service.utils;

import com.leacooking.LeaCooking.api.entity.*;
import com.leacooking.LeaCooking.api.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class EntityReferenceService {

    private final IngredientRepository ingredientRepository;

    @Transactional(readOnly = true)
    public Ingredient findIngredientById(Long id) {
        return id != null ? this.ingredientRepository.getReferenceById(id) : null;
    }
}
