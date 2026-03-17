package com.leacooking.LeaCooking.api.repository;

import com.leacooking.LeaCooking.api.entity.RecipeSubcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeSubcategoryRepository extends JpaRepository<RecipeSubcategory, Long> {
}
