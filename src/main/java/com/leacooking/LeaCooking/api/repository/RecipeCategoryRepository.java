package com.leacooking.LeaCooking.api.repository;

import com.leacooking.LeaCooking.api.entity.RecipeCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeCategoryRepository extends JpaRepository<RecipeCategory, Long> {
}
