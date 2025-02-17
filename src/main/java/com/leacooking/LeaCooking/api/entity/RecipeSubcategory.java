package com.leacooking.LeaCooking.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "recipe_subcategory")
public class RecipeSubcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipe_subcategory_id_gen")
    @SequenceGenerator(name = "recipe_subcategory_id_gen", sequenceName = "recipe_subcategory_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "label", nullable = false)
    private String label;

    @OneToMany(mappedBy = "recipeSubcategory")
    private Set<Recipe> recipes = new LinkedHashSet<>();

    @ManyToOne
    @JoinColumn(name = "id_recipe_category", nullable = false)
    private RecipeCategory recipeCategory;
}
