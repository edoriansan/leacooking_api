package com.leacooking.LeaCooking.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "recipe_ingredient")
public class RecipeIngredient {
    @SequenceGenerator(name = "recipe_ingredient_id_gen", sequenceName = "recipe_part_seq", allocationSize = 1)
    @EmbeddedId
    private RecipeIngredientId id;

    @MapsId("idRecipe")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_recipe", nullable = false)
    private Recipe idRecipe;

    @MapsId("idIngredient")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_ingredient", nullable = false)
    private Ingredient idIngredient;

    @MapsId("idRecipePart")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_recipe_part", nullable = false)
    private RecipePart idRecipePart;

    @Column(name = "ingredient_quantity", nullable = false)
    private Integer ingredientQuantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_quantity_type")
    private QuantityType idQuantityType;

}