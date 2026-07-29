package com.leacooking.LeaCooking.api.repository;

import com.leacooking.LeaCooking.api.entity.RecipeCategory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class RecipeCategoryRepositoryTest {
    @Autowired
    private RecipeCategoryRepository recipeCategoryRepository;

    @Test
    @DisplayName("create recipe category")
    void shouldCreateRecipeCategory() {
        RecipeCategory category = new RecipeCategory();
        category.setRecipeCategoryLabel("Salé");
        category.setRecipeCategoryImg("salt.jpg");

        RecipeCategory savedCategory = recipeCategoryRepository.save(category);

        assertThat(savedCategory.getId()).isNotNull();
        assertThat(savedCategory.getRecipeCategoryLabel()).isEqualTo("Salé");
        assertThat(savedCategory.getRecipeCategoryImg()).isEqualTo("salt.jpg");
    }

    @Test
    @DisplayName("read recipe category by id")
    void shouldReadRecipeCategoryById() {
        RecipeCategory category = new RecipeCategory();
        category.setRecipeCategoryLabel("Sucré");
        category.setRecipeCategoryImg("sugar.jpg");

        RecipeCategory savedCategory = recipeCategoryRepository.save(category);

        Optional<RecipeCategory> foundCategory = recipeCategoryRepository.findById(savedCategory.getId());

        assertThat(foundCategory).isPresent();
        assertThat(foundCategory.get().getRecipeCategoryLabel()).isEqualTo("Sucré");
        assertThat(foundCategory.get().getRecipeCategoryImg()).isEqualTo("sugar.jpg");
    }

    @Test
    @DisplayName("edit recipe category")
    void shouldUpdateRecipeCategory() {
        RecipeCategory category = new RecipeCategory();
        category.setRecipeCategoryLabel("Dessert");
        category.setRecipeCategoryImg("dessert.jpg");

        RecipeCategory savedCategory = recipeCategoryRepository.save(category);
        savedCategory.setRecipeCategoryLabel("Desserts");
        savedCategory.setRecipeCategoryImg("desserts.jpg");

        RecipeCategory updatedCategory = recipeCategoryRepository.save(savedCategory);

        assertThat(updatedCategory.getId()).isEqualTo(savedCategory.getId());
        assertThat(updatedCategory.getRecipeCategoryLabel()).isEqualTo("Desserts");
        assertThat(updatedCategory.getRecipeCategoryImg()).isEqualTo("desserts.jpg");
    }

    @Test
    @DisplayName("delete recipe category")
    void shouldDeleteRecipeCategory() {
        RecipeCategory category = new RecipeCategory();
        category.setRecipeCategoryLabel("Salé");
        category.setRecipeCategoryImg("salt.jpg");
        RecipeCategory savedCategory = recipeCategoryRepository.save(category);
        recipeCategoryRepository.delete(savedCategory);

        Optional<RecipeCategory> deletedCategory = recipeCategoryRepository.findById(savedCategory.getId());

        assertThat(deletedCategory).isEmpty();
    }
}
