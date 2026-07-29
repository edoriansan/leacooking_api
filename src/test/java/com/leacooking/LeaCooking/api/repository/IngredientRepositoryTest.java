package com.leacooking.LeaCooking.api.repository;

import com.leacooking.LeaCooking.api.entity.Ingredient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class IngredientRepositoryTest {
    @Autowired
    private IngredientRepository ingredientRepository;

    @Test
    @DisplayName("create ingredient")
    void shouldCreateIngredient() {
        Ingredient ingredient = new Ingredient();
        ingredient.setLabel("Tomate");

        Ingredient savedIngredient = ingredientRepository.save(ingredient);

        assertThat(savedIngredient.getId()).isNotNull();
        assertThat(savedIngredient.getLabel()).isEqualTo("Tomate");
    }

    @Test
    @DisplayName("get ingredient by id")
    void shouldReadIngredientById() {
        Ingredient ingredient = new Ingredient();
        ingredient.setLabel("Farine");

        Ingredient savedIngredient = ingredientRepository.save(ingredient);

        Optional<Ingredient> foundIngredient = ingredientRepository.findById(savedIngredient.getId());

        assertThat(foundIngredient).isPresent();
        assertThat(foundIngredient.get().getLabel()).isEqualTo("Farine");
    }

    @Test
    @DisplayName("edit ingredient")
    void shouldUpdateIngredient() {
        Ingredient ingredient = new Ingredient();
        ingredient.setLabel("Sucre");

        Ingredient savedIngredient = ingredientRepository.save(ingredient);
        savedIngredient.setLabel("Sucre roux");

        Ingredient updatedIngredient = ingredientRepository.save(savedIngredient);

        assertThat(updatedIngredient.getId()).isEqualTo(savedIngredient.getId());
        assertThat(updatedIngredient.getLabel()).isEqualTo("Sucre roux");
    }

    @Test
    @DisplayName("delete ingredient")
    void shouldDeleteIngredient() {
        Ingredient ingredient = new Ingredient();
        ingredient.setLabel("Beurre");
        Ingredient savedIngredient = ingredientRepository.save(ingredient);
        ingredientRepository.delete(savedIngredient);
        Optional<Ingredient> deletedIngredient = ingredientRepository.findById(savedIngredient.getId());

        assertThat(deletedIngredient).isEmpty();
    }
}