package com.leacooking.LeaCooking.api.repository;

import com.leacooking.LeaCooking.api.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
