package com.leacooking.LeaCooking.api.repository;

import com.leacooking.LeaCooking.api.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
