package com.parsa.recipe.ingredient;


import com.parsa.recipe.common.BaseEntity;
import com.parsa.recipe.recipe.Recipe;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "tbl_ingredient")

public class Ingredient extends BaseEntity {

    @Column(name = "description")
    private String description;

    @Column(name = "amount")
    private Integer amount;

    @ManyToOne()
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;




}
