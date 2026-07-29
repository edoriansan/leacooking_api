package com.leacooking.LeaCooking.api.repository;

import com.leacooking.LeaCooking.api.entity.Ingredient;
import com.leacooking.LeaCooking.api.entity.Recipe;
import com.leacooking.LeaCooking.api.entity.RecipeCategory;
import com.leacooking.LeaCooking.api.entity.RecipeIngredient;
import com.leacooking.LeaCooking.api.entity.RecipeSubcategory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class RecipeIngredientRepositoryTest {
    @Autowired
    private RecipeIngredientRepository recipeIngredientRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private RecipeCategoryRepository recipeCategoryRepository;

    @Autowired
    private RecipeSubcategoryRepository recipeSubcategoryRepository;

    @Test
    @DisplayName("create recipe ingredient")
    void shouldCreateRecipeIngredient() {
        Recipe recipe = createRecipe();
        Ingredient ingredient = createIngredient();

        RecipeIngredient recipeIngredient = new RecipeIngredient();
        recipeIngredient.setRecipe(recipe);
        recipeIngredient.setIngredient(ingredient);
        recipeIngredient.setQuantity("200g");

        RecipeIngredient savedRecipeIngredient = recipeIngredientRepository.save(recipeIngredient);

        assertThat(savedRecipeIngredient.getId()).isNotNull();
        assertThat(savedRecipeIngredient.getRecipe().getId()).isEqualTo(recipe.getId());
        assertThat(savedRecipeIngredient.getIngredient().getId()).isEqualTo(ingredient.getId());
        assertThat(savedRecipeIngredient.getQuantity()).isEqualTo("200g");
    }

    @Test
    @DisplayName("read recipe ingredient by id")
    void shouldReadRecipeIngredientById() {
        Recipe recipe = createRecipe();
        Ingredient ingredient = createIngredient();

        RecipeIngredient recipeIngredient = new RecipeIngredient();
        recipeIngredient.setRecipe(recipe);
        recipeIngredient.setIngredient(ingredient);
        recipeIngredient.setQuantity("3 pièces");

        RecipeIngredient savedRecipeIngredient = recipeIngredientRepository.save(recipeIngredient);

        Optional<RecipeIngredient> foundRecipeIngredient =
                recipeIngredientRepository.findById(savedRecipeIngredient.getId());

        assertThat(foundRecipeIngredient).isPresent();
        assertThat(foundRecipeIngredient.get().getRecipe().getId()).isEqualTo(recipe.getId());
        assertThat(foundRecipeIngredient.get().getIngredient().getId()).isEqualTo(ingredient.getId());
        assertThat(foundRecipeIngredient.get().getQuantity()).isEqualTo("3 pièces");
    }

    @Test
    @DisplayName("edit recipe ingredient")
    void shouldUpdateRecipeIngredient() {
        Recipe recipe = createRecipe();
        Ingredient ingredient = createIngredient();

        RecipeIngredient recipeIngredient = new RecipeIngredient();
        recipeIngredient.setRecipe(recipe);
        recipeIngredient.setIngredient(ingredient);
        recipeIngredient.setQuantity("100g");

        RecipeIngredient savedRecipeIngredient = recipeIngredientRepository.save(recipeIngredient);
        savedRecipeIngredient.setQuantity("150g");

        RecipeIngredient updatedRecipeIngredient = recipeIngredientRepository.save(savedRecipeIngredient);

        assertThat(updatedRecipeIngredient.getId()).isEqualTo(savedRecipeIngredient.getId());
        assertThat(updatedRecipeIngredient.getRecipe().getId()).isEqualTo(recipe.getId());
        assertThat(updatedRecipeIngredient.getIngredient().getId()).isEqualTo(ingredient.getId());
        assertThat(updatedRecipeIngredient.getQuantity()).isEqualTo("150g");
    }

    @Test
    @DisplayName("delete recipe ingredient")
    void shouldDeleteRecipeIngredient() {
        Recipe recipe = createRecipe();
        Ingredient ingredient = createIngredient();

        RecipeIngredient recipeIngredient = new RecipeIngredient();
        recipeIngredient.setRecipe(recipe);
        recipeIngredient.setIngredient(ingredient);
        recipeIngredient.setQuantity("1 pincée");

        RecipeIngredient savedRecipeIngredient = recipeIngredientRepository.save(recipeIngredient);

        recipeIngredientRepository.delete(savedRecipeIngredient);

        Optional<RecipeIngredient> deletedRecipeIngredient =
                recipeIngredientRepository.findById(savedRecipeIngredient.getId());

        assertThat(deletedRecipeIngredient).isEmpty();
    }

    private Ingredient createIngredient() {
        Ingredient ingredient = new Ingredient();
        ingredient.setLabel("Farine");

        return ingredientRepository.save(ingredient);
    }

    private Recipe createRecipe() {
        RecipeCategory category = new RecipeCategory();
        category.setRecipeCategoryLabel("Salé");
        category.setRecipeCategoryImg("sale.jpg");

        RecipeCategory savedCategory = recipeCategoryRepository.save(category);

        RecipeSubcategory subcategory = new RecipeSubcategory();
        subcategory.setRecipeSubcategoryLabel("Bases salées");
        subcategory.setRecipeSubcategoryImg("bases-salees.jpg");
        subcategory.setRecipeCategory(savedCategory);

        RecipeSubcategory savedSubcategory = recipeSubcategoryRepository.save(subcategory);

        Recipe recipe = new Recipe();
        recipe.setTitle("Pâte maison");
        recipe.setDescription("Mélanger les ingrédients puis pétrir.");
        recipe.setParts(4);
        recipe.setRecipeImg("pate.jpg");
        recipe.setRecipeSubcategory(savedSubcategory);

        return recipeRepository.save(recipe);
    }
}
