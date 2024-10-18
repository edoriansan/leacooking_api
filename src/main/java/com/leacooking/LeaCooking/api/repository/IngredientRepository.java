package com.leacooking.LeaCooking.api.repository;

import com.leacooking.LeaCooking.api.entity.Ingredient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    @Query("""
            SELECT i
            FROM Ingredient i
                WHERE (
                    :search is null
                    OR upper(i.label) LIKE '%' || upper(:search) || '%'
                )
                ORDER BY i.label DESC
            """)
    Page<Ingredient> searchLight(Pageable pageable, String search);

}
