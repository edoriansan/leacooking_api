package com.leacooking.LeaCooking.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "recipe_part_ingredient")
public class RecipePartIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipe_part_ingredient_id_gen")
    @SequenceGenerator(name = "recipe_part_ingredient_id_gen", sequenceName = "recipe_part_ingredient_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_recipe_part", nullable = false)
    private RecipePart recipePart;

    @ManyToOne
    @JoinColumn(name = "id_ingredient", nullable = false)
    private Ingredient ingredient;

    @Column(name = "quantity", nullable = false)
    private String quantity;
}
