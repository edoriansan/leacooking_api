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
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "label", nullable = false)
    private String label;

    @ManyToOne
    @JoinColumn(name = "id_recipe", nullable = false)  // Assurez-vous que cette colonne existe dans votre base de données
    private Recipe recipe;

    @OneToMany(mappedBy = "recipePart", cascade = CascadeType.ALL)
    private Set<RecipePartIngredient> recipePartIngredients = new LinkedHashSet<>();
}
