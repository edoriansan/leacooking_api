package com.leacooking.LeaCooking.api.repository;

import com.leacooking.LeaCooking.api.entity.RecipePart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipePartRepository extends JpaRepository<RecipePart, Long> {
}