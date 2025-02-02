package com.leacooking.LeaCooking.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "quantity_type")
public class QuantityType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quantity_type_id_gen")
    @SequenceGenerator(name = "quantity_type_id_gen", sequenceName = "quantity_type_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "label")
    private String label;

    @OneToMany(mappedBy = "quantityType")
    private Set<Ingredient> ingredients = new LinkedHashSet<>();

}