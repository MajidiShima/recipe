package com.parsa.recipe.category_list;

import com.parsa.recipe.common.BaseDTO;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

public class CategoryList extends BaseDTO {


    @NotNull
    @Column(name = "title")
    private String title;


    @ManyToOne
    @JoinColumn(name = "category_id")

}
