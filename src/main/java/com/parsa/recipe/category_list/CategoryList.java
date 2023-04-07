package com.parsa.recipe.category_list;

import com.parsa.recipe.category.Category;
import com.parsa.recipe.common.BaseDTO;
import com.parsa.recipe.common.BaseEntity;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "tbl_category_list")
@Data
@Audited
public class CategoryList extends BaseEntity {

    @NotNull
    @Column(name = "title")
    private String title;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;




}
