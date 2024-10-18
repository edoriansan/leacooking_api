package com.leacooking.LeaCooking.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "recipe_part")
public class RecipePart {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipe_part_id_gen")
    @SequenceGenerator(name = "recipe_part_id_gen", sequenceName = "recipe_part_seq", allocationSize = 1)
    private Long id;

    private String label;

    @ManyToOne
    @JoinColumn(name = "id_recipe", nullable = false)
    private Recipe recipe;

    @OneToMany(mappedBy = "recipePart", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RecipePartIngredient> recipePartIngredients = new LinkedHashSet<>();
}
