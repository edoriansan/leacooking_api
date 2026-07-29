package com.leacooking.LeaCooking.api.repository;

import com.leacooking.LeaCooking.api.entity.RecipeCategory;
import com.leacooking.LeaCooking.api.entity.RecipeSubcategory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class RecipeSubcategoryRepositoryTest {
    @Autowired
    private RecipeSubcategoryRepository recipeSubcategoryRepository;

    @Autowired
    private RecipeCategoryRepository recipeCategoryRepository;

    @Test
    @DisplayName("create recipe subcategory")
    void shouldCreateRecipeSubcategory() {
        RecipeCategory category = createCategory();

        RecipeSubcategory subcategory = new RecipeSubcategory();
        subcategory.setRecipeSubcategoryLabel("Pâtes");
        subcategory.setRecipeSubcategoryImg("pasta.jpg");
        subcategory.setRecipeCategory(category);

        RecipeSubcategory savedSubcategory = recipeSubcategoryRepository.save(subcategory);

        assertThat(savedSubcategory.getId()).isNotNull();
        assertThat(savedSubcategory.getRecipeSubcategoryLabel()).isEqualTo("Pâtes");
        assertThat(savedSubcategory.getRecipeSubcategoryImg()).isEqualTo("pasta.jpg");
        assertThat(savedSubcategory.getRecipeCategory().getId()).isEqualTo(category.getId());
    }

    @Test
    @DisplayName("read recipe subcategory by id")
    void shouldReadRecipeSubcategoryById() {
        RecipeCategory category = createCategory();

        RecipeSubcategory subcategory = new RecipeSubcategory();
        subcategory.setRecipeSubcategoryLabel("Pizza");
        subcategory.setRecipeSubcategoryImg("pizza.jpg");
        subcategory.setRecipeCategory(category);

        RecipeSubcategory savedSubcategory = recipeSubcategoryRepository.save(subcategory);

        Optional<RecipeSubcategory> foundSubcategory =
                recipeSubcategoryRepository.findById(savedSubcategory.getId());

        assertThat(foundSubcategory).isPresent();
        assertThat(foundSubcategory.get().getRecipeSubcategoryLabel()).isEqualTo("Pizza");
        assertThat(foundSubcategory.get().getRecipeSubcategoryImg()).isEqualTo("pizza.jpg");
        assertThat(foundSubcategory.get().getRecipeCategory().getId()).isEqualTo(category.getId());
    }

    @Test
    @DisplayName("edit recipe subcategory")
    void shouldUpdateRecipeSubcategory() {
        RecipeCategory category = createCategory();

        RecipeSubcategory subcategory = new RecipeSubcategory();
        subcategory.setRecipeSubcategoryLabel("Viande");
        subcategory.setRecipeSubcategoryImg("meat.jpg");
        subcategory.setRecipeCategory(category);

        RecipeSubcategory savedSubcategory = recipeSubcategoryRepository.save(subcategory);
        savedSubcategory.setRecipeSubcategoryLabel("Poisson");
        savedSubcategory.setRecipeSubcategoryImg("fish.jpg");

        RecipeSubcategory updatedSubcategory = recipeSubcategoryRepository.save(savedSubcategory);

        assertThat(updatedSubcategory.getId()).isEqualTo(savedSubcategory.getId());
        assertThat(updatedSubcategory.getRecipeSubcategoryLabel()).isEqualTo("Poisson");
        assertThat(updatedSubcategory.getRecipeSubcategoryImg()).isEqualTo("fish.jpg");
    }

    @Test
    @DisplayName("Supprimer une sous-catégorie de recette")
    void shouldDeleteRecipeSubcategory() {
        RecipeCategory category = createCategory();

        RecipeSubcategory subcategory = new RecipeSubcategory();
        subcategory.setRecipeSubcategoryLabel("Cake");
        subcategory.setRecipeSubcategoryImg("cake.jpg");
        subcategory.setRecipeCategory(category);

        RecipeSubcategory savedSubcategory = recipeSubcategoryRepository.save(subcategory);

        recipeSubcategoryRepository.delete(savedSubcategory);

        Optional<RecipeSubcategory> deletedSubcategory =
                recipeSubcategoryRepository.findById(savedSubcategory.getId());

        assertThat(deletedSubcategory).isEmpty();
    }

    private RecipeCategory createCategory() {
        RecipeCategory category = new RecipeCategory();
        category.setRecipeCategoryLabel("Bases");
        category.setRecipeCategoryImg("bases.jpg");

        return recipeCategoryRepository.save(category);
    }
}
