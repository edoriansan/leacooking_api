package com.leacooking.LeaCooking.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class RecipeIngredientId implements Serializable {
    private static final long serialVersionUID = 855221448126331725L;
    @Column(name = "id_recipe", nullable = false)
    private Long idRecipe;

    @Column(name = "id_ingredient", nullable = false)
    private Long idIngredient;

    @Column(name = "id_recipe_part", nullable = false)
    private Long idRecipePart;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RecipeIngredientId entity = (RecipeIngredientId) o;
        return Objects.equals(this.idRecipePart, entity.idRecipePart) &&
                Objects.equals(this.idIngredient, entity.idIngredient) &&
                Objects.equals(this.idRecipe, entity.idRecipe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRecipePart, idIngredient, idRecipe);
    }

}