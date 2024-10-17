package com.leacooking.LeaCooking.api.repository;

import com.leacooking.LeaCooking.api.entity.Recipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    @Query("""
            SELECT r
            FROM Recipe r
                WHERE (
                    :search is null
                    OR upper(r.title) LIKE upper(CONCAT('%', :search ,'%') )
                )
                ORDER BY r.title DESC
            """)
    Page<Recipe> searchLight(Pageable pageable, String search);

}
