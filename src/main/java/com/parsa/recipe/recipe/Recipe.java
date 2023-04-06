package com.parsa.recipe.recipe;


import com.parsa.recipe.common.BaseEntity;
import com.parsa.recipe.ingredient.Ingredient;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tbl_recipe")
@Data
@Audited
public class Recipe extends BaseEntity {


    @NotNull
    @Column(name="title")
    private String  title;

    @NotNull
    @Column(name = "prepTime")
    private Integer prepTime;

    @NotNull
    @Column(name = "cookTime")
    private Integer cookTime;

    @NotNull
    @Column(name = "difficulty")
    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;


    @OneToMany(mappedBy = "recipe",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Ingredient> ingredients;



}
