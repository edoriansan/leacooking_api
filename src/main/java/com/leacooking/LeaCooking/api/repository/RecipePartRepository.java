package com.leacooking.LeaCooking.api.repository;

import com.leacooking.LeaCooking.api.entity.RecipePart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface RecipePartRepository extends JpaRepository<RecipePart, Long> {
    @Query("""
        SELECT rp
        FROM RecipePart rp
        INNER JOIN FETCH rp.recipePartIngredients rpi
        INNER JOIN FETCH rpi.ingredient i
        INNER JOIN FETCH i.quantityType q
        WHERE rp.recipe.id = :idRecipe
        ORDER BY rp.recipePartTitle DESC
    """)
    Set<RecipePart> findAllByRecipeId(Long idRecipe);
}