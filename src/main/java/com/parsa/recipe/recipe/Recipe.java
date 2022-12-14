package com.parsa.recipe.recipe;


import com.parsa.recipe.common.BaseEntity;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_food")
@Data
@Audited
public class Recipe extends BaseEntity {


    @NotNull
    @Column(name="title")
    private String  title;

    @Column(name = "prepTime")
    private Integer prepTime;

    @Column(name = "cookTime")
    private Integer cookTime;


    @Column(name = "source")
    private String source;

    @Column(name = "image")
    private String image;


    @NotNull
    @Column(name = "difficulty")
    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

}
