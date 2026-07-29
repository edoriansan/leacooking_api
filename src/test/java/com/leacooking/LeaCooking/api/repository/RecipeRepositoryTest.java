package com.leacooking.LeaCooking.api.repository;

import com.leacooking.LeaCooking.api.entity.Recipe;
import com.leacooking.LeaCooking.api.entity.RecipeCategory;
import com.leacooking.LeaCooking.api.entity.RecipeSubcategory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class RecipeRepositoryTest {
    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private RecipeCategoryRepository recipeCategoryRepository;

    @Autowired
    private RecipeSubcategoryRepository recipeSubcategoryRepository;

    @Test
    @DisplayName("create recipe")
    void shouldCreateRecipe() {
        RecipeSubcategory subcategory = createSubcategory();

        Recipe recipe = new Recipe();
        recipe.setTitle("Lasagnes");
        recipe.setDescription("Préparer les lasagnes puis enfourner.");
        recipe.setParts(4);
        recipe.setRecipeImg("lasagna.jpg");
        recipe.setRecipeSubcategory(subcategory);

        Recipe savedRecipe = recipeRepository.save(recipe);

        assertThat(savedRecipe.getId()).isNotNull();
        assertThat(savedRecipe.getTitle()).isEqualTo("Lasagnes");
        assertThat(savedRecipe.getDescription()).isEqualTo("Préparer les lasagnes puis enfourner.");
        assertThat(savedRecipe.getParts()).isEqualTo(4);
        assertThat(savedRecipe.getRecipeImg()).isEqualTo("lasagna.jpg");
        assertThat(savedRecipe.getRecipeSubcategory().getId()).isEqualTo(subcategory.getId());
    }

    @Test
    @DisplayName("read recipe by id")
    void shouldReadRecipeById() {
        RecipeSubcategory subcategory = createSubcategory();

        Recipe recipe = new Recipe();
        recipe.setTitle("Risotto");
        recipe.setDescription("Faire cuire le riz progressivement avec le bouillon.");
        recipe.setParts(2);
        recipe.setRecipeImg("risotto.jpg");
        recipe.setRecipeSubcategory(subcategory);

        Recipe savedRecipe = recipeRepository.save(recipe);

        Optional<Recipe> foundRecipe = recipeRepository.findById(savedRecipe.getId());

        assertThat(foundRecipe).isPresent();
        assertThat(foundRecipe.get().getTitle()).isEqualTo("Risotto");
        assertThat(foundRecipe.get().getDescription())
                .isEqualTo("Faire cuire le riz progressivement avec le bouillon.");
        assertThat(foundRecipe.get().getParts()).isEqualTo(2);
        assertThat(foundRecipe.get().getRecipeImg()).isEqualTo("risotto.jpg");
        assertThat(foundRecipe.get().getRecipeSubcategory().getId()).isEqualTo(subcategory.getId());
    }

    @Test
    @DisplayName("edit recipe")
    void shouldUpdateRecipe() {
        RecipeSubcategory subcategory = createSubcategory();

        Recipe recipe = new Recipe();
        recipe.setTitle("Pizza");
        recipe.setDescription("Préparer la pâte et garnir.");
        recipe.setParts(1);
        recipe.setRecipeImg("pizza.jpg");
        recipe.setRecipeSubcategory(subcategory);

        Recipe savedRecipe = recipeRepository.save(recipe);
        savedRecipe.setTitle("Pizza maison");
        savedRecipe.setDescription("Préparer la pâte, garnir puis enfourner.");
        savedRecipe.setParts(2);
        savedRecipe.setRecipeImg("pizza.jpg");

        Recipe updatedRecipe = recipeRepository.save(savedRecipe);

        assertThat(updatedRecipe.getId()).isEqualTo(savedRecipe.getId());
        assertThat(updatedRecipe.getTitle()).isEqualTo("Pizza maison");
        assertThat(updatedRecipe.getDescription()).isEqualTo("Préparer la pâte, garnir puis enfourner.");
        assertThat(updatedRecipe.getParts()).isEqualTo(2);
        assertThat(updatedRecipe.getRecipeImg()).isEqualTo("pizza.jpg");
        assertThat(updatedRecipe.getRecipeSubcategory().getId()).isEqualTo(subcategory.getId());
    }

    @Test
    @DisplayName("delete recipe")
    void shouldDeleteRecipe() {
        RecipeSubcategory subcategory = createSubcategory();

        Recipe recipe = new Recipe();
        recipe.setTitle("Cake aux olives");
        recipe.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit...");
        recipe.setParts(3);
        recipe.setRecipeImg("olives_cake.jpg");
        recipe.setRecipeSubcategory(subcategory);

        Recipe savedRecipe = recipeRepository.save(recipe);

        recipeRepository.delete(savedRecipe);

        Optional<Recipe> deletedRecipe = recipeRepository.findById(savedRecipe.getId());

        assertThat(deletedRecipe).isEmpty();
    }

    private RecipeSubcategory createSubcategory() {
        RecipeCategory category = new RecipeCategory();
        category.setRecipeCategoryLabel("Salé");
        category.setRecipeCategoryImg("sale.jpg");

        RecipeCategory savedCategory = recipeCategoryRepository.save(category);

        RecipeSubcategory subcategory = new RecipeSubcategory();
        subcategory.setRecipeSubcategoryLabel("Pâtes");
        subcategory.setRecipeSubcategoryImg("pates.jpg");
        subcategory.setRecipeCategory(savedCategory);

        return recipeSubcategoryRepository.save(subcategory);
    }
}
